package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "items_param")
public class ItemsParam {
    /**
     * ��Ʒ����id
     */
    @Id
    private String id;

    /**
     * ��Ʒ���id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * ���� ���أ������й�����
     */
    @Column(name = "produc_place")
    private String producPlace;

    /**
     * ������ �����ڣ�����180��
     */
    @Column(name = "foot_period")
    private String footPeriod;

    /**
     * Ʒ���� Ʒ������������ֻ�����
     */
    private String brand;

    /**
     * �������� ������������������ǹ���
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * ������ַ ������ַ�������������������
     */
    @Column(name = "factory_address")
    private String factoryAddress;

    /**
     * ��װ��ʽ ��װ��ʽ��������װ
     */
    @Column(name = "packaging_method")
    private String packagingMethod;

    /**
     * ������� �������������35g
     */
    private String weight;

    /**
     * �洢���� �洢��������������5~25��
     */
    @Column(name = "storage_method")
    private String storageMethod;

    /**
     * ʳ�÷�ʽ ʳ�÷�ʽ������������ʳ
     */
    @Column(name = "eat_method")
    private String eatMethod;

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
     * ��ȡ��Ʒ����id
     *
     * @return id - ��Ʒ����id
     */
    public String getId() {
        return id;
    }

    /**
     * ������Ʒ����id
     *
     * @param id ��Ʒ����id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ��Ʒ���id
     *
     * @return item_id - ��Ʒ���id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * ������Ʒ���id
     *
     * @param itemId ��Ʒ���id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * ��ȡ���� ���أ������й�����
     *
     * @return produc_place - ���� ���أ������й�����
     */
    public String getProducPlace() {
        return producPlace;
    }

    /**
     * ���ò��� ���أ������й�����
     *
     * @param producPlace ���� ���أ������й�����
     */
    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace;
    }

    /**
     * ��ȡ������ �����ڣ�����180��
     *
     * @return foot_period - ������ �����ڣ�����180��
     */
    public String getFootPeriod() {
        return footPeriod;
    }

    /**
     * ���ñ����� �����ڣ�����180��
     *
     * @param footPeriod ������ �����ڣ�����180��
     */
    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod;
    }

    /**
     * ��ȡƷ���� Ʒ������������ֻ�����
     *
     * @return brand - Ʒ���� Ʒ������������ֻ�����
     */
    public String getBrand() {
        return brand;
    }

    /**
     * ����Ʒ���� Ʒ������������ֻ�����
     *
     * @param brand Ʒ���� Ʒ������������ֻ�����
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * ��ȡ�������� ������������������ǹ���
     *
     * @return factory_name - �������� ������������������ǹ���
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * ������������ ������������������ǹ���
     *
     * @param factoryName �������� ������������������ǹ���
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    /**
     * ��ȡ������ַ ������ַ�������������������
     *
     * @return factory_address - ������ַ ������ַ�������������������
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * ����������ַ ������ַ�������������������
     *
     * @param factoryAddress ������ַ ������ַ�������������������
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    /**
     * ��ȡ��װ��ʽ ��װ��ʽ��������װ
     *
     * @return packaging_method - ��װ��ʽ ��װ��ʽ��������װ
     */
    public String getPackagingMethod() {
        return packagingMethod;
    }

    /**
     * ���ð�װ��ʽ ��װ��ʽ��������װ
     *
     * @param packagingMethod ��װ��ʽ ��װ��ʽ��������װ
     */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    /**
     * ��ȡ������� �������������35g
     *
     * @return weight - ������� �������������35g
     */
    public String getWeight() {
        return weight;
    }

    /**
     * ���ù������ �������������35g
     *
     * @param weight ������� �������������35g
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * ��ȡ�洢���� �洢��������������5~25��
     *
     * @return storage_method - �洢���� �洢��������������5~25��
     */
    public String getStorageMethod() {
        return storageMethod;
    }

    /**
     * ���ô洢���� �洢��������������5~25��
     *
     * @param storageMethod �洢���� �洢��������������5~25��
     */
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    /**
     * ��ȡʳ�÷�ʽ ʳ�÷�ʽ������������ʳ
     *
     * @return eat_method - ʳ�÷�ʽ ʳ�÷�ʽ������������ʳ
     */
    public String getEatMethod() {
        return eatMethod;
    }

    /**
     * ����ʳ�÷�ʽ ʳ�÷�ʽ������������ʳ
     *
     * @param eatMethod ʳ�÷�ʽ ʳ�÷�ʽ������������ʳ
     */
    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod;
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