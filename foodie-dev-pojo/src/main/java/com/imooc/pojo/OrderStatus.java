package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order_status")
public class OrderStatus {
    /**
     * ����ID;��Ӧ�����������id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * ����״̬
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * ��������ʱ��;��Ӧ[10:������]״̬
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * ֧���ɹ�ʱ��;��Ӧ[20:�Ѹ��������]״̬
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * ����ʱ��;��Ӧ[30���ѷ��������ջ�]״̬
     */
    @Column(name = "deliver_time")
    private Date deliverTime;

    /**
     * ���׳ɹ�ʱ��;��Ӧ[40�����׳ɹ�]״̬
     */
    @Column(name = "success_time")
    private Date successTime;

    /**
     * ���׹ر�ʱ��;��Ӧ[50�����׹ر�]״̬
     */
    @Column(name = "close_time")
    private Date closeTime;

    /**
     * ����ʱ��;�û��ڽ��׳ɹ��������ʱ��
     */
    @Column(name = "comment_time")
    private Date commentTime;

    /**
     * ��ȡ����ID;��Ӧ�����������id
     *
     * @return order_id - ����ID;��Ӧ�����������id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * ���ö���ID;��Ӧ�����������id
     *
     * @param orderId ����ID;��Ӧ�����������id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * ��ȡ����״̬
     *
     * @return order_status - ����״̬
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * ���ö���״̬
     *
     * @param orderStatus ����״̬
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * ��ȡ��������ʱ��;��Ӧ[10:������]״̬
     *
     * @return created_time - ��������ʱ��;��Ӧ[10:������]״̬
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * ���ö�������ʱ��;��Ӧ[10:������]״̬
     *
     * @param createdTime ��������ʱ��;��Ӧ[10:������]״̬
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * ��ȡ֧���ɹ�ʱ��;��Ӧ[20:�Ѹ��������]״̬
     *
     * @return pay_time - ֧���ɹ�ʱ��;��Ӧ[20:�Ѹ��������]״̬
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * ����֧���ɹ�ʱ��;��Ӧ[20:�Ѹ��������]״̬
     *
     * @param payTime ֧���ɹ�ʱ��;��Ӧ[20:�Ѹ��������]״̬
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * ��ȡ����ʱ��;��Ӧ[30���ѷ��������ջ�]״̬
     *
     * @return deliver_time - ����ʱ��;��Ӧ[30���ѷ��������ջ�]״̬
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * ���÷���ʱ��;��Ӧ[30���ѷ��������ջ�]״̬
     *
     * @param deliverTime ����ʱ��;��Ӧ[30���ѷ��������ջ�]״̬
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * ��ȡ���׳ɹ�ʱ��;��Ӧ[40�����׳ɹ�]״̬
     *
     * @return success_time - ���׳ɹ�ʱ��;��Ӧ[40�����׳ɹ�]״̬
     */
    public Date getSuccessTime() {
        return successTime;
    }

    /**
     * ���ý��׳ɹ�ʱ��;��Ӧ[40�����׳ɹ�]״̬
     *
     * @param successTime ���׳ɹ�ʱ��;��Ӧ[40�����׳ɹ�]״̬
     */
    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    /**
     * ��ȡ���׹ر�ʱ��;��Ӧ[50�����׹ر�]״̬
     *
     * @return close_time - ���׹ر�ʱ��;��Ӧ[50�����׹ر�]״̬
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * ���ý��׹ر�ʱ��;��Ӧ[50�����׹ر�]״̬
     *
     * @param closeTime ���׹ر�ʱ��;��Ӧ[50�����׹ر�]״̬
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * ��ȡ����ʱ��;�û��ڽ��׳ɹ��������ʱ��
     *
     * @return comment_time - ����ʱ��;�û��ڽ��׳ɹ��������ʱ��
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * ��������ʱ��;�û��ڽ��׳ɹ��������ʱ��
     *
     * @param commentTime ����ʱ��;�û��ڽ��׳ɹ��������ʱ��
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}