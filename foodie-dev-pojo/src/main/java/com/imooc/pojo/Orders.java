package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Orders {
    /**
     * ��������;ͬʱҲ�Ƕ������
     */
    @Id
    private String id;

    /**
     * �û�id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * �ջ��˿���
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * �ջ����ֻ��ſ���
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * �ջ���ַ����
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * �����ܼ۸�
     */
    @Column(name = "total_amount")
    private Integer totalAmount;

    /**
     * ʵ��֧���ܼ۸�
     */
    @Column(name = "real_pay_amount")
    private Integer realPayAmount;

    /**
     * �ʷ�;Ĭ�Ͽ���Ϊ�㣬�������
     */
    @Column(name = "post_amount")
    private Integer postAmount;

    /**
     * ֧����ʽ
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    /**
     * �������
     */
    @Column(name = "left_msg")
    private String leftMsg;

    /**
     * ��չ�ֶ�
     */
    private String extand;

    /**
     * ����Ƿ�����;1�������ۣ�0��δ����
     */
    @Column(name = "is_comment")
    private Integer isComment;

    /**
     * �߼�ɾ��״̬;1: ɾ�� 0:δɾ��
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * ����ʱ�䣨�ɽ�ʱ�䣩
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * ����ʱ��
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * ��ȡ��������;ͬʱҲ�Ƕ������
     *
     * @return id - ��������;ͬʱҲ�Ƕ������
     */
    public String getId() {
        return id;
    }

    /**
     * ���ö�������;ͬʱҲ�Ƕ������
     *
     * @param id ��������;ͬʱҲ�Ƕ������
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ�û�id
     *
     * @return user_id - �û�id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * �����û�id
     *
     * @param userId �û�id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ��ȡ�ջ��˿���
     *
     * @return receiver_name - �ջ��˿���
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * �����ջ��˿���
     *
     * @param receiverName �ջ��˿���
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * ��ȡ�ջ����ֻ��ſ���
     *
     * @return receiver_mobile - �ջ����ֻ��ſ���
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * �����ջ����ֻ��ſ���
     *
     * @param receiverMobile �ջ����ֻ��ſ���
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * ��ȡ�ջ���ַ����
     *
     * @return receiver_address - �ջ���ַ����
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * �����ջ���ַ����
     *
     * @param receiverAddress �ջ���ַ����
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * ��ȡ�����ܼ۸�
     *
     * @return total_amount - �����ܼ۸�
     */
    public Integer getTotalAmount() {
        return totalAmount;
    }

    /**
     * ���ö����ܼ۸�
     *
     * @param totalAmount �����ܼ۸�
     */
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * ��ȡʵ��֧���ܼ۸�
     *
     * @return real_pay_amount - ʵ��֧���ܼ۸�
     */
    public Integer getRealPayAmount() {
        return realPayAmount;
    }

    /**
     * ����ʵ��֧���ܼ۸�
     *
     * @param realPayAmount ʵ��֧���ܼ۸�
     */
    public void setRealPayAmount(Integer realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    /**
     * ��ȡ�ʷ�;Ĭ�Ͽ���Ϊ�㣬�������
     *
     * @return post_amount - �ʷ�;Ĭ�Ͽ���Ϊ�㣬�������
     */
    public Integer getPostAmount() {
        return postAmount;
    }

    /**
     * �����ʷ�;Ĭ�Ͽ���Ϊ�㣬�������
     *
     * @param postAmount �ʷ�;Ĭ�Ͽ���Ϊ�㣬�������
     */
    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    /**
     * ��ȡ֧����ʽ
     *
     * @return pay_method - ֧����ʽ
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * ����֧����ʽ
     *
     * @param payMethod ֧����ʽ
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * ��ȡ�������
     *
     * @return left_msg - �������
     */
    public String getLeftMsg() {
        return leftMsg;
    }

    /**
     * �����������
     *
     * @param leftMsg �������
     */
    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    /**
     * ��ȡ��չ�ֶ�
     *
     * @return extand - ��չ�ֶ�
     */
    public String getExtand() {
        return extand;
    }

    /**
     * ������չ�ֶ�
     *
     * @param extand ��չ�ֶ�
     */
    public void setExtand(String extand) {
        this.extand = extand;
    }

    /**
     * ��ȡ����Ƿ�����;1�������ۣ�0��δ����
     *
     * @return is_comment - ����Ƿ�����;1�������ۣ�0��δ����
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * ��������Ƿ�����;1�������ۣ�0��δ����
     *
     * @param isComment ����Ƿ�����;1�������ۣ�0��δ����
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * ��ȡ�߼�ɾ��״̬;1: ɾ�� 0:δɾ��
     *
     * @return is_delete - �߼�ɾ��״̬;1: ɾ�� 0:δɾ��
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * �����߼�ɾ��״̬;1: ɾ�� 0:δɾ��
     *
     * @param isDelete �߼�ɾ��״̬;1: ɾ�� 0:δɾ��
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * ��ȡ����ʱ�䣨�ɽ�ʱ�䣩
     *
     * @return created_time - ����ʱ�䣨�ɽ�ʱ�䣩
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * ���ô���ʱ�䣨�ɽ�ʱ�䣩
     *
     * @param createdTime ����ʱ�䣨�ɽ�ʱ�䣩
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return updated_time - ����ʱ��
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * ���ø���ʱ��
     *
     * @param updatedTime ����ʱ��
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}