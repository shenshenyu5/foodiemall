package com.imooc.controller;

import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.IMOOCJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
public class BaseController {
    public static  final  String FOODIE_SHOPCART = "shopcart";
    public static final Integer COMMON_PAGE_SIZE = 10 ;
    public static final Integer PAGE_SIZE = 20 ;
    @Autowired
   private MyOrdersService myOrdersService;
    //微信支付成功-》支付中心->平台
    public String  payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    // 支付中心的调用地址
    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";

    //上传用户头像的地址
    public static final String IMAGE_USER_FACE_LOCALTION = "E:"+ File.separator+"foodiedev";

    /**
     * 用于验证用户id和订单id是否有关联
     *
     * @return
     */
    public IMOOCJSONResult checkUserOrder(String userId, String orderId) {
        Orders order =  myOrdersService.queryMyOrder(userId,orderId);

        if (order==null) {
            IMOOCJSONResult.errorMsg("用户和订单没有关系");
        }
        return  IMOOCJSONResult.ok(order);
    }

}

