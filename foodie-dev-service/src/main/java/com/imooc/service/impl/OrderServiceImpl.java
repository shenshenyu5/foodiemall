package com.imooc.service.impl;

import com.imooc.enums.YesOrNo;
import com.imooc.mapper.OrderItemsMapper;
import com.imooc.mapper.OrdersMapper;
import com.imooc.pojo.*;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.service.AddressService;
import com.imooc.service.ItemService;
import com.imooc.service.OrderService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


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
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void createOrder(SubmitOrderBO submitOrderBO) {
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
                 }
                 newOrder.setTotalAmount(totalAmount);
                 newOrder.setRealPayAmount(realPayAmout);
                 ordersMapper.insert(newOrder);
        //3.保存订单状态表
    }
}
