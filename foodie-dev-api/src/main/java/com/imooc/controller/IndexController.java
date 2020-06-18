package com.imooc.controller;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class IndexController {
    /**
     * 首页展示分类展示要求
     * 1.第一次刷新主页查询大类，渲染展示到首页
     * 2.如果鼠标移到大类上，则加载其子分类的内容，如果已经存在子分类则不加载（懒加载）
     */
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取商品分类（一级分类）", notes = "", httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
       List<Category> list =  categoryService.queryAllRootLevelCat();

            return IMOOCJSONResult.ok(list);

        }

    @ApiOperation(value = "获取商品分类（一级分类）", notes = "", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public IMOOCJSONResult sixNewItems(
            @ApiParam(name = "rootCatId",value = "一级分类id",required = true)
            @PathVariable Integer rootCatId
            ) {
        if(rootCatId ==null){
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);

        return IMOOCJSONResult.ok(list);
     }

}
