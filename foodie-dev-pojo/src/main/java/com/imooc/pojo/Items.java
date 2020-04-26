package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Items {
    /**
     * ��Ʒ����id
     */
    @Id
    private String id;

    /**
     * ��Ʒ���� ��Ʒ����
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * �������id ����id
     */
    @Column(name = "cat_id")
    private Integer catId;

    /**
     * һ���������id
     */
    @Column(name = "root_cat_id")
    private Integer rootCatId;

    /**
     * �ۼ����� �ۼ�����
     */
    @Column(name = "sell_counts")
    private Integer sellCounts;

    /**
     * ���¼�״̬ ���¼�״̬,1:�ϼ� 2:�¼�
     */
    @Column(name = "on_off_status")
    private Integer onOffStatus;

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
     * ��Ʒ���� ��Ʒ����
     */
    private String content;

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
     * ��ȡ��Ʒ���� ��Ʒ����
     *
     * @return item_name - ��Ʒ���� ��Ʒ����
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * ������Ʒ���� ��Ʒ����
     *
     * @param itemName ��Ʒ���� ��Ʒ����
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * ��ȡ�������id ����id
     *
     * @return cat_id - �������id ����id
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * ���÷������id ����id
     *
     * @param catId �������id ����id
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * ��ȡһ���������id
     *
     * @return root_cat_id - һ���������id
     */
    public Integer getRootCatId() {
        return rootCatId;
    }

    /**
     * ����һ���������id
     *
     * @param rootCatId һ���������id
     */
    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    /**
     * ��ȡ�ۼ����� �ۼ�����
     *
     * @return sell_counts - �ۼ����� �ۼ�����
     */
    public Integer getSellCounts() {
        return sellCounts;
    }

    /**
     * �����ۼ����� �ۼ�����
     *
     * @param sellCounts �ۼ����� �ۼ�����
     */
    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    /**
     * ��ȡ���¼�״̬ ���¼�״̬,1:�ϼ� 2:�¼�
     *
     * @return on_off_status - ���¼�״̬ ���¼�״̬,1:�ϼ� 2:�¼�
     */
    public Integer getOnOffStatus() {
        return onOffStatus;
    }

    /**
     * �������¼�״̬ ���¼�״̬,1:�ϼ� 2:�¼�
     *
     * @param onOffStatus ���¼�״̬ ���¼�״̬,1:�ϼ� 2:�¼�
     */
    public void setOnOffStatus(Integer onOffStatus) {
        this.onOffStatus = onOffStatus;
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

    /**
     * ��ȡ��Ʒ���� ��Ʒ����
     *
     * @return content - ��Ʒ���� ��Ʒ����
     */
    public String getContent() {
        return content;
    }

    /**
     * ������Ʒ���� ��Ʒ����
     *
     * @param content ��Ʒ���� ��Ʒ����
     */
    public void setContent(String content) {
        this.content = content;
    }
}