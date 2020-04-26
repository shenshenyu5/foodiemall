package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_address")
public class UserAddress {
    /**
     * ��ַ����id
     */
    @Id
    private String id;

    /**
     * �����û�id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * �ռ�������
     */
    private String receiver;

    /**
     * �ռ����ֻ���
     */
    private String mobile;

    /**
     * ʡ��
     */
    private String province;

    /**
     * ����
     */
    private String city;

    /**
     * ����
     */
    private String district;

    /**
     * ��ϸ��ַ
     */
    private String detail;

    /**
     * ��չ�ֶ�
     */
    private String extand;

    /**
     * �Ƿ�Ĭ�ϵ�ַ
     */
    @Column(name = "is_default")
    private Integer isDefault;

    /**
     * ����ʱ��
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * ����ʱ��
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * ��ȡ��ַ����id
     *
     * @return id - ��ַ����id
     */
    public String getId() {
        return id;
    }

    /**
     * ���õ�ַ����id
     *
     * @param id ��ַ����id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ�����û�id
     *
     * @return user_id - �����û�id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ���ù����û�id
     *
     * @param userId �����û�id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ��ȡ�ռ�������
     *
     * @return receiver - �ռ�������
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * �����ռ�������
     *
     * @param receiver �ռ�������
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * ��ȡ�ռ����ֻ���
     *
     * @return mobile - �ռ����ֻ���
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * �����ռ����ֻ���
     *
     * @param mobile �ռ����ֻ���
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * ��ȡʡ��
     *
     * @return province - ʡ��
     */
    public String getProvince() {
        return province;
    }

    /**
     * ����ʡ��
     *
     * @param province ʡ��
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * ��ȡ����
     *
     * @return city - ����
     */
    public String getCity() {
        return city;
    }

    /**
     * ���ó���
     *
     * @param city ����
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * ��ȡ����
     *
     * @return district - ����
     */
    public String getDistrict() {
        return district;
    }

    /**
     * ��������
     *
     * @param district ����
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * ��ȡ��ϸ��ַ
     *
     * @return detail - ��ϸ��ַ
     */
    public String getDetail() {
        return detail;
    }

    /**
     * ������ϸ��ַ
     *
     * @param detail ��ϸ��ַ
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
     * ��ȡ�Ƿ�Ĭ�ϵ�ַ
     *
     * @return is_default - �Ƿ�Ĭ�ϵ�ַ
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * �����Ƿ�Ĭ�ϵ�ַ
     *
     * @param isDefault �Ƿ�Ĭ�ϵ�ַ
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return created_time - ����ʱ��
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createdTime ����ʱ��
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