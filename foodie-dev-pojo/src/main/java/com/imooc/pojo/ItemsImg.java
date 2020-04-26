package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "items_img")
public class ItemsImg {
    /**
     * ͼƬ����
     */
    @Id
    private String id;

    /**
     * ��Ʒ���id ��Ʒ���id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * ͼƬ��ַ ͼƬ��ַ
     */
    private String url;

    /**
     * ˳�� ͼƬ˳�򣬴�С����
     */
    private Integer sort;

    /**
     * �Ƿ���ͼ �Ƿ���ͼ��1���ǣ�0����
     */
    @Column(name = "is_main")
    private Integer isMain;

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
     * ��ȡͼƬ����
     *
     * @return id - ͼƬ����
     */
    public String getId() {
        return id;
    }

    /**
     * ����ͼƬ����
     *
     * @param id ͼƬ����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ��Ʒ���id ��Ʒ���id
     *
     * @return item_id - ��Ʒ���id ��Ʒ���id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * ������Ʒ���id ��Ʒ���id
     *
     * @param itemId ��Ʒ���id ��Ʒ���id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * ��ȡͼƬ��ַ ͼƬ��ַ
     *
     * @return url - ͼƬ��ַ ͼƬ��ַ
     */
    public String getUrl() {
        return url;
    }

    /**
     * ����ͼƬ��ַ ͼƬ��ַ
     *
     * @param url ͼƬ��ַ ͼƬ��ַ
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * ��ȡ˳�� ͼƬ˳�򣬴�С����
     *
     * @return sort - ˳�� ͼƬ˳�򣬴�С����
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * ����˳�� ͼƬ˳�򣬴�С����
     *
     * @param sort ˳�� ͼƬ˳�򣬴�С����
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * ��ȡ�Ƿ���ͼ �Ƿ���ͼ��1���ǣ�0����
     *
     * @return is_main - �Ƿ���ͼ �Ƿ���ͼ��1���ǣ�0����
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * �����Ƿ���ͼ �Ƿ���ͼ��1���ǣ�0����
     *
     * @param isMain �Ƿ���ͼ �Ƿ���ͼ��1���ǣ�0����
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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