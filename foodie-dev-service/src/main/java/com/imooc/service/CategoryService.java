package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * 查询所有一级分类
 */
public interface CategoryService {
    public List<Category> queryAllRootLevelCat();

    /**
     * 查询首页每个分类下面的  6条最新商品数据
     * @param rootCatId
     * @return
     */
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
