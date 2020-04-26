package com.imooc.pojo;

import javax.persistence.*;

public class Category {
    /**
     * ����
     */
    @Id
    private Integer id;

    /**
     * ��������
     */
    private String name;

    /**
     * ��������
     */
    private Integer type;

    /**
     * ��id
     */
    @Column(name = "father_id")
    private Integer fatherId;

    /**
     * ͼ��
     */
    private String logo;

    /**
     * �ں�
     */
    private String slogan;

    /**
     * ����ͼ
     */
    @Column(name = "cat_image")
    private String catImage;

    /**
     * ������ɫ
     */
    @Column(name = "bg_color")
    private String bgColor;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public Integer getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡ��������
     *
     * @return name - ��������
     */
    public String getName() {
        return name;
    }

    /**
     * ���÷�������
     *
     * @param name ��������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ��������
     *
     * @return type - ��������
     */
    public Integer getType() {
        return type;
    }

    /**
     * ���÷�������
     *
     * @param type ��������
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * ��ȡ��id
     *
     * @return father_id - ��id
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * ���ø�id
     *
     * @param fatherId ��id
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * ��ȡͼ��
     *
     * @return logo - ͼ��
     */
    public String getLogo() {
        return logo;
    }

    /**
     * ����ͼ��
     *
     * @param logo ͼ��
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * ��ȡ�ں�
     *
     * @return slogan - �ں�
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * ���ÿں�
     *
     * @param slogan �ں�
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    /**
     * ��ȡ����ͼ
     *
     * @return cat_image - ����ͼ
     */
    public String getCatImage() {
        return catImage;
    }

    /**
     * ���÷���ͼ
     *
     * @param catImage ����ͼ
     */
    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    /**
     * ��ȡ������ɫ
     *
     * @return bg_color - ������ɫ
     */
    public String getBgColor() {
        return bgColor;
    }

    /**
     * ���ñ�����ɫ
     *
     * @param bgColor ������ɫ
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}