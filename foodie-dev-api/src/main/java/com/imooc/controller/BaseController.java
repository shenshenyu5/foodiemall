package com.imooc.controller;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    public static  final  String FOODIE_SHOPCART = "shopcart";
    public static final Integer COMMENT_PAGE_SIZE = 10 ;
    public static final Integer PAGE_SIZE = 20 ;

    //微信支付成功-》支付中心->平台
    public String  payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    // 支付中心的调用地址
    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";
}

