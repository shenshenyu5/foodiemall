package com.imooc.service.center;

import com.imooc.pojo.OrderItems;
import com.imooc.pojo.bo.center.OrderItemsCommentBO;

import java.util.List;

public interface MyCommentsService {
    /**
     * 根据订单id查询对应的商品
     * @param orderId
     * @return
     */
    public List<OrderItems> queryPendingComments(String orderId);

    /**
     *
     * 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    public void saveComments(String orderId,String userId,List<OrderItemsCommentBO> commentList);
}
