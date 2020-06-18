package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.pojo.vo.SearchItemsVO;
import com.imooc.pojo.vo.ShopcartVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface ItemService {
    /**
     * 根据商品id查询商品
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemPara(String itemId);

    /**
     * 根据商品id查询商品评价等级数量
     * @param itemId
     * @return
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * g根据商品id查询商品评价 （分页）
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult querypagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(String keywords, String sort,Integer page, Integer pageSize);

    /**
     * 根据商品id搜索列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(Integer catId, String sort,Integer page, Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中商品数s据）
     * @param specIds
     * @return
     */
    public List<ShopcartVO> queryItemsBySpecIds (String specIds);

    /**
     * 根据商品规格id查询商品
     * @param specId
     * @return
     */
    public ItemsSpec queryItemSpecById(String specId);

    /**
     * 根据商品id来获取主图的地址
     * @param itemId
     * @return
     */
    public String queryItemMainImgById(String itemId);
}
