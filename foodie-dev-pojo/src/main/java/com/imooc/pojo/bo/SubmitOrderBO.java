package com.imooc.pojo.bo;

public class SubmitOrderBO {
    private String userId;
    private String itemSpecId;
    private String choosedAddressId;
    private Integer  choosedPayMethod;
    private String leftMsg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public String getChoosedAddressId() {
        return choosedAddressId;
    }

    public void setChoosedAddressId(String choosedAddressId) {
        this.choosedAddressId = choosedAddressId;
    }

    public Integer getChoosedPayMethod() {
        return choosedPayMethod;
    }

    public void setChoosedPayMethod(Integer choosedPayMethod) {
        this.choosedPayMethod = choosedPayMethod;
    }

    public String getLeftMsg() {
        return leftMsg;
    }

    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    @Override
    public String toString() {
        return "SubmitOrderBO{" +
                "userId='" + userId + '\'' +
                ", itemSpecId='" + itemSpecId + '\'' +
                ", choosedAddressId='" + choosedAddressId + '\'' +
                ", choosedPayMethod=" + choosedPayMethod +
                ", leftMsg='" + leftMsg + '\'' +
                '}';
    }
}
