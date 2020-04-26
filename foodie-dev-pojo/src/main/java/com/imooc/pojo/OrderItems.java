package com.imooc.pojo;

import javax.persistence.*;

@Table(name = "order_items")
public class OrderItems {
    /**
     * ����id
     */
    @Id
    private String id;

    /**
     * ��������id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * ��Ʒid
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * ��ƷͼƬ
     */
    @Column(name = "item_img")
    private String itemImg;

    /**
     * ��Ʒ����
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * ���id
     */
    @Column(name = "item_spec_id")
    private String itemSpecId;

    /**
     * �������
     */
    @Column(name = "item_spec_name")
    private String itemSpecName;

    /**
     * �ɽ��۸�
     */
    private Integer price;

    /**
     * ��������
     */
    @Column(name = "buy_counts")
    private Integer buyCounts;

    /**
     * ��ȡ����id
     *
     * @return id - ����id
     */
    public String getId() {
        return id;
    }

    /**
     * ��������id
     *
     * @param id ����id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ��������id
     *
     * @return order_id - ��������id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * ���ù�������id
     *
     * @param orderId ��������id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * ��ȡ��Ʒid
     *
     * @return item_id - ��Ʒid
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * ������Ʒid
     *
     * @param itemId ��Ʒid
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * ��ȡ��ƷͼƬ
     *
     * @return item_img - ��ƷͼƬ
     */
    public String getItemImg() {
        return itemImg;
    }

    /**
     * ������ƷͼƬ
     *
     * @param itemImg ��ƷͼƬ
     */
    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    /**
     * ��ȡ��Ʒ����
     *
     * @return item_name - ��Ʒ����
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * ������Ʒ����
     *
     * @param itemName ��Ʒ����
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * ��ȡ���id
     *
     * @return item_spec_id - ���id
     */
    public String getItemSpecId() {
        return itemSpecId;
    }

    /**
     * ���ù��id
     *
     * @param itemSpecId ���id
     */
    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    /**
     * ��ȡ�������
     *
     * @return item_spec_name - �������
     */
    public String getItemSpecName() {
        return itemSpecName;
    }

    /**
     * ���ù������
     *
     * @param itemSpecName �������
     */
    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    /**
     * ��ȡ�ɽ��۸�
     *
     * @return price - �ɽ��۸�
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * ���óɽ��۸�
     *
     * @param price �ɽ��۸�
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * ��ȡ��������
     *
     * @return buy_counts - ��������
     */
    public Integer getBuyCounts() {
        return buyCounts;
    }

    /**
     * ���ù�������
     *
     * @param buyCounts ��������
     */
    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }
}