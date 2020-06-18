package com.imooc.enums;

/**
 * @author George
 */
public enum  PayMethod {
    /**
     * type为类型 value为含义
     */
    WEIXIN(1,"微信"),
    ALIPAY(2,"支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value) {
            this.type=type;
            this.value =value;

    }

}
