package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "items_comments")
public class ItemsComments {
    /**
     * id����
     */
    @Id
    private String id;

    /**
     * �û�id �û���������
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * ��Ʒid
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * ��Ʒ����
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * ��Ʒ���id ��Ϊ��
     */
    @Column(name = "item_spec_id")
    private String itemSpecId;

    /**
     * ������� ��Ϊ��
     */
    @Column(name = "sepc_name")
    private String sepcName;

    /**
     * ���۵ȼ� 1������ 2������ 3������
     */
    @Column(name = "comment_level")
    private Integer commentLevel;

    /**
     * ��������
     */
    private String content;

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
     * ��ȡid����
     *
     * @return id - id����
     */
    public String getId() {
        return id;
    }

    /**
     * ����id����
     *
     * @param id id����
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ��ȡ�û�id �û���������
     *
     * @return user_id - �û�id �û���������
     */
    public String getUserId() {
        return userId;
    }

    /**
     * �����û�id �û���������
     *
     * @param userId �û�id �û���������
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * ��ȡ��Ʒ���id ��Ϊ��
     *
     * @return item_spec_id - ��Ʒ���id ��Ϊ��
     */
    public String getItemSpecId() {
        return itemSpecId;
    }

    /**
     * ������Ʒ���id ��Ϊ��
     *
     * @param itemSpecId ��Ʒ���id ��Ϊ��
     */
    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    /**
     * ��ȡ������� ��Ϊ��
     *
     * @return sepc_name - ������� ��Ϊ��
     */
    public String getSepcName() {
        return sepcName;
    }

    /**
     * ���ù������ ��Ϊ��
     *
     * @param sepcName ������� ��Ϊ��
     */
    public void setSepcName(String sepcName) {
        this.sepcName = sepcName;
    }

    /**
     * ��ȡ���۵ȼ� 1������ 2������ 3������
     *
     * @return comment_level - ���۵ȼ� 1������ 2������ 3������
     */
    public Integer getCommentLevel() {
        return commentLevel;
    }

    /**
     * �������۵ȼ� 1������ 2������ 3������
     *
     * @param commentLevel ���۵ȼ� 1������ 2������ 3������
     */
    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    /**
     * ��ȡ��������
     *
     * @return content - ��������
     */
    public String getContent() {
        return content;
    }

    /**
     * ������������
     *
     * @param content ��������
     */
    public void setContent(String content) {
        this.content = content;
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