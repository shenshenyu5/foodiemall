package com.imooc.controller;

import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemInfoVO;
import com.imooc.pojo.vo.NewItemsVO;
import com.imooc.pojo.vo.ShopcartVO;
import com.imooc.service.CategoryService;
import com.imooc.service.ItemService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "商品接口",tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemController extends  BaseController{
    /**
     * 首页展示分类展示要求
     * 1.第一次刷新主页查询大类，渲染展示到首页
     * 2.如果鼠标移到大类上，则加载其子分类的内容，如果已经存在子分类则不加载（懒加载）
     */
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(
            @ApiParam(name = "itemId",value = "商品iD",required = true)
            @PathVariable String itemId){
        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        Items item = itemService.queryItemById(itemId);
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemSpecList= itemService.queryItemSpecList(itemId);
        ItemsParam itemParam = itemService.queryItemPara(itemId);
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.getItemImgList(itemImgList);
        itemInfoVO.getItemSpecList(itemSpecList);
        itemInfoVO.getItemsParams(itemParam);
        return IMOOCJSONResult.ok(itemInfoVO);
     }


    @ApiOperation(value = "查询商品评价数量", notes = "查询商品评价数量", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(
            @ApiParam(name = "itemId",value = "商品iD",required = true)
            @RequestParam String itemId){
        if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }

        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);
        return IMOOCJSONResult.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评价", notes = "查询商品评价", httpMethod = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult comments(
            @ApiParam(name = "itemId",value = "商品iD",required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level",value = "等级",required = false)
            @RequestParam Integer level,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页记录数",required = false)
            @RequestParam Integer pageSize ){
         if (StringUtils.isBlank(itemId)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult grid = itemService.querypagedComments(itemId,level,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }


    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public IMOOCJSONResult search(
            @ApiParam(name = "keywords",value = "关键字",required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort",value = "等级",required = false)
            @RequestParam String sort,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页记录数",required = false)
            @RequestParam Integer pageSize
    ){

        if (StringUtils.isBlank(keywords)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searchItems(keywords,sort,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }

    /**
     * 用于用户长的时间未登录刷新购物车的数据 主要是商品价格类似京东淘宝
     * @param itemSpecIds
     * @return
     */
    @ApiOperation(value = "根据商品规格id查找最新商品数据", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/refresh")
    public IMOOCJSONResult refresh(
            @ApiParam(name = "itemSpecIds",value = "拼接的Ids",required = true,example = "1001,1003,1005")
            @RequestParam String itemSpecIds
    ){
        if (StringUtils.isBlank(itemSpecIds)) {
            return IMOOCJSONResult.ok();
        }
       List<ShopcartVO> list =  itemService.queryItemsBySpecIds(itemSpecIds);
        return IMOOCJSONResult.ok(list);
    }


    @ApiOperation(value = "通过分类id搜索商品列表", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/catItems")
    public IMOOCJSONResult catItems(
            @ApiParam(name = "catId",value = "分类id",required = true)
            @RequestParam String catId,
            @ApiParam(name = "sort",value = "等级",required = false)
            @RequestParam String sort,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页记录数",required = false)
            @RequestParam Integer pageSize
    ){
        if (StringUtils.isBlank(catId)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = PAGE_SIZE;
        }

        PagedGridResult grid = itemService.searchItems(catId,sort,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }
}
