package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Carousel {
    /**
     * ����
     */
    @Id
    private String id;

    /**
     * ͼƬ ͼƬ��ַ
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * ����ɫ
     */
    @Column(name = "background_color")
    private String backgroundColor;

    /**
     * ��Ʒid ��Ʒid
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * ��Ʒ����id ��Ʒ����id
     */
    @Column(name = "cat_id")
    private String catId;

    /**
     * �ֲ�ͼ���� �ֲ�ͼ���ͣ������жϣ����Ը�����Ʒid���߷������ҳ����ת��1����Ʒ 2������
     */
    private Integer type;

    /**
     * �ֲ�ͼչʾ˳��
     */
    private Integer sort;

    /**
     * �Ƿ�չʾ
     */
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * ����ʱ�� ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ����ʱ�� ����
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public String getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡͼƬ ͼƬ��ַ
     *
     * @return image_url - ͼƬ ͼƬ��ַ
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * ����ͼƬ ͼƬ��ַ
     *
     * @param imageUrl ͼƬ ͼƬ��ַ
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * ��ȡ����ɫ
     *
     * @return background_color - ����ɫ
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * ���ñ���ɫ
     *
     * @param backgroundColor ����ɫ
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * ��ȡ��Ʒid ��Ʒid
     *
     * @return item_id - ��Ʒid ��Ʒid
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * ������Ʒid ��Ʒid
     *
     * @param itemId ��Ʒid ��Ʒid
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * ��ȡ��Ʒ����id ��Ʒ����id
     *
     * @return cat_id - ��Ʒ����id ��Ʒ����id
     */
    public String getCatId() {
        return catId;
    }

    /**
     * ������Ʒ����id ��Ʒ����id
     *
     * @param catId ��Ʒ����id ��Ʒ����id
     */
    public void setCatId(String catId) {
        this.catId = catId;
    }

    /**
     * ��ȡ�ֲ�ͼ���� �ֲ�ͼ���ͣ������жϣ����Ը�����Ʒid���߷������ҳ����ת��1����Ʒ 2������
     *
     * @return type - �ֲ�ͼ���� �ֲ�ͼ���ͣ������жϣ����Ը�����Ʒid���߷������ҳ����ת��1����Ʒ 2������
     */
    public Integer getType() {
        return type;
    }

    /**
     * �����ֲ�ͼ���� �ֲ�ͼ���ͣ������жϣ����Ը�����Ʒid���߷������ҳ����ת��1����Ʒ 2������
     *
     * @param type �ֲ�ͼ���� �ֲ�ͼ���ͣ������жϣ����Ը�����Ʒid���߷������ҳ����ת��1����Ʒ 2������
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * ��ȡ�ֲ�ͼչʾ˳��
     *
     * @return sort - �ֲ�ͼչʾ˳��
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * �����ֲ�ͼչʾ˳��
     *
     * @param sort �ֲ�ͼչʾ˳��
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * ��ȡ�Ƿ�չʾ
     *
     * @return is_show - �Ƿ�չʾ
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * �����Ƿ�չʾ
     *
     * @param isShow �Ƿ�չʾ
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * ��ȡ����ʱ�� ����ʱ��
     *
     * @return create_time - ����ʱ�� ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ�� ����ʱ��
     *
     * @param createTime ����ʱ�� ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ����ʱ�� ����
     *
     * @return update_time - ����ʱ�� ����
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * ���ø���ʱ�� ����
     *
     * @param updateTime ����ʱ�� ����
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}