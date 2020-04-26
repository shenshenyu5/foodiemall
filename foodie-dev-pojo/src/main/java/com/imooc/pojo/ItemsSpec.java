package com.imooc.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "items_spec")
public class ItemsSpec {
    /**
     * ��Ʒ���id
     */
    @Id
    private String id;

    /**
     * ��Ʒ���id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * �������
     */
    private String name;

    /**
     * ���
     */
    private Integer stock;

    /**
     * �ۿ�����
     */
    private BigDecimal discounts;

    /**
     * �Żݼ�
     */
    @Column(name = "price_discount")
    private Integer priceDiscount;

    /**
     * ԭ��
     */
    @Column(name = "price_normal")
    private Integer priceNormal;

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
     * ��ȡ��Ʒ���id
     *
     * @return id - ��Ʒ���id
     */
    public String getId() {
        return id;
    }

    /**
     * ������Ʒ���id
     *
     * @param id ��Ʒ���id
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
     * ��ȡ�������
     *
     * @return name - �������
     */
    public String getName() {
        return name;
    }

    /**
     * ���ù������
     *
     * @param name �������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ���
     *
     * @return stock - ���
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * ���ÿ��
     *
     * @param stock ���
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * ��ȡ�ۿ�����
     *
     * @return discounts - �ۿ�����
     */
    public BigDecimal getDiscounts() {
        return discounts;
    }

    /**
     * �����ۿ�����
     *
     * @param discounts �ۿ�����
     */
    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    /**
     * ��ȡ�Żݼ�
     *
     * @return price_discount - �Żݼ�
     */
    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    /**
     * �����Żݼ�
     *
     * @param priceDiscount �Żݼ�
     */
    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    /**
     * ��ȡԭ��
     *
     * @return price_normal - ԭ��
     */
    public Integer getPriceNormal() {
        return priceNormal;
    }

    /**
     * ����ԭ��
     *
     * @param priceNormal ԭ��
     */
    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
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