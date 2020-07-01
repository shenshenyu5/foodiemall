package com.imooc.service.impl;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.YesOrNo;
import com.imooc.mapper.OrderItemsMapper;
import com.imooc.mapper.OrderStatusMapper;
import com.imooc.mapper.OrdersMapper;
import com.imooc.pojo.*;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.pojo.vo.MerchantOrdersVO;
import com.imooc.pojo.vo.OrderVO;
import com.imooc.service.AddressService;
import com.imooc.service.ItemService;
import com.imooc.service.OrderService;
import com.imooc.utils.DateUtil;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
   private   OrdersMapper ordersMapper;
    @Autowired
    private Sid sid;

    @Autowired
    private AddressService addressService;
    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired

    private OrderStatusMapper orderStatusMapper;
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public OrderVO createOrder(SubmitOrderBO submitOrderBO) {
             String userId = submitOrderBO.getUserId();
             String addressId = submitOrderBO.getChoosedAddressId();
             String itemSpecIds = submitOrderBO.getItemSpecId();
             Integer payMethod = submitOrderBO.getChoosedPayMethod();
             String leftMsg = submitOrderBO.getLeftMsg();
             //设置邮费
            Integer postAmount = 0 ;

            String orderId = sid.nextShort();

            //1.新订单数据保存
                Orders newOrder = new Orders();
                newOrder.setId(orderId);
                newOrder.setUserId(userId);

               UserAddress resultAddress =  addressService.queryUserAddress(userId,addressId);
               newOrder.setReceiverAddress(resultAddress.getProvince()+resultAddress.getCity()+resultAddress.getDistrict()+resultAddress.getDetail());
               newOrder.setReceiverMobile(resultAddress.getMobile());
               newOrder.setReceiverName(resultAddress.getReceiver());

                //TODO 价格
                //TODO 实际支付的价格
                newOrder.setPostAmount(postAmount);
                newOrder.setPayMethod(payMethod);
                newOrder.setLeftMsg(leftMsg);
                newOrder.setIsComment(YesOrNo.NO.type);
                newOrder.setIsDelete(YesOrNo.NO.type);
                newOrder.setCreatedTime(new Date());
                newOrder.setUpdatedTime(new Date());
            //2.循环根据itemSpecIds保存订单商品信息表
                String[] itemSpecIdArr =  itemSpecIds.split(",");
                //商品原件累计
                Integer totalAmount = 0;
                //优惠后的价格的累计
                Integer realPayAmout = 0 ;

                 for (String itemSpecId:itemSpecIdArr) {
                    //TODO 整合REdis后商品购买的数量重新从redis的购物车中获取
                    //2.1根据规格id，查询规则的具体信息，价格

                     int buyCounts = 1;
                     ItemsSpec itemsSpec =  itemService.queryItemSpecById(itemSpecId);
                     totalAmount += itemsSpec.getPriceNormal()*buyCounts;
                     realPayAmout += itemsSpec.getPriceDiscount()*buyCounts;
                    //根据商品id获得商品信息和商品图片
                     String itemId = itemsSpec.getItemId();
                    Items item =  itemService.queryItemById(itemId);
                    String imgUrl = itemService.queryItemMainImgById(itemId);
                    //2.3循环保存订单数据到数据库
                     String subOrderId = sid.nextShort();
                     OrderItems subOrderItem = new OrderItems();
                     subOrderItem.setId(subOrderId);
                     subOrderItem.setOrderId(orderId);
                     subOrderItem.setItemId(itemId);
                     subOrderItem.setItemName(item.getItemName());
                     subOrderItem.setItemImg(imgUrl);
                     subOrderItem.setBuyCounts(buyCounts);
                     subOrderItem.setItemSpecId(itemSpecId);
                     subOrderItem.setItemSpecName(itemsSpec.getName());
                     subOrderItem.setPrice(itemsSpec.getPriceDiscount());
                     orderItemsMapper.insert(subOrderItem);
                     //2.4 在用户提交订单后，规格表中要扣除库存
                     itemService.decreaseItemSpecStock(itemSpecId,buyCounts);
                 }
                 newOrder.setTotalAmount(totalAmount);
                 newOrder.setRealPayAmount(realPayAmout);
                 ordersMapper.insert(newOrder);
        //3.保存订单状态表
        OrderStatus waitPayOrderStatus = new OrderStatus();
        waitPayOrderStatus.setOrderId(orderId);
        waitPayOrderStatus.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        waitPayOrderStatus.setCreatedTime(new Date());
        orderStatusMapper.insert(waitPayOrderStatus);

        //4.构建商户订单 用于传给支付中心
        MerchantOrdersVO merchantOrdersVO = new MerchantOrdersVO();
        merchantOrdersVO.setMerchantOrderId(orderId);
        merchantOrdersVO.setMerchantUserId(userId);
        merchantOrdersVO.setAmount(realPayAmout+postAmount);
        merchantOrdersVO.setPayMethod(payMethod);

        //5.构建自定义vo
        OrderVO orderVO = new OrderVO();
        orderVO.setOrderId(orderId);
        orderVO.setMerchantOrdersVO(merchantOrdersVO);

        return orderVO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateOrderStatus(String orderId, Integer orderStatus) {
        OrderStatus paidStatus = new OrderStatus();
        paidStatus.setOrderId(orderId);
        paidStatus.setOrderStatus(orderStatus);
        paidStatus.setPayTime(new Date());
        orderStatusMapper.updateByPrimaryKey(paidStatus);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public OrderStatus queryOrderStatusInfo(String orderId) {
        return orderStatusMapper.selectByPrimaryKey(orderId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void closeOrder() {
        //查询所有未付款的订单，判断时间是否超时（1天）超时则关闭交易
        OrderStatus queryOrder = new OrderStatus();
        queryOrder.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        List<OrderStatus> list =  orderStatusMapper.select(queryOrder);
        for (OrderStatus os: list ) {
            //获取订单创建时间
            Date createdTime = os.getCreatedTime();
            //和当前时间对比
          int days =   DateUtil.daysBetween(createdTime,new Date());
            if (days>=1) {
                //关闭订单
                doCloseOrder(os.getOrderId());
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    void doCloseOrder(String orderId){
        OrderStatus close =new OrderStatus();
        close.setOrderId(orderId);
        close.setOrderStatus(OrderStatusEnum.CLOSE.type);
        close.setCloseTime(new Date());
        orderStatusMapper.updateByPrimaryKey(close);
    }
}
