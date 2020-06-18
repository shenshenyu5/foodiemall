package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口",tags = {"购物车的相关接口"})
@RestController
@RequestMapping("/shopcart")
public class ShopCartController extends  BaseController{

    @ApiOperation(value = "加入购物车", notes = "加入购物车", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @RequestBody ShopcartBO shopCartBO,
            HttpServletRequest request,
            HttpServletResponse response) {
            if (StringUtils.isBlank(userId)) {
                return  IMOOCJSONResult.errorMsg("");
            }

                //TODO 前端用户在登录状态下，添加商品到购物车，会同时在后端同步到Redis缓存



                return IMOOCJSONResult.ok();

            }

    @ApiOperation(value = "从购物车中把商品删除", notes = "从购物车中把商品删除", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @ApiParam(name = "itemSpecId",value = "商品规格id",required = true)
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (StringUtils.isBlank(userId)||StringUtils.isBlank(itemSpecId)) {
            return  IMOOCJSONResult.errorMsg("参数不能为空");
        }

        //TODO 用户在页面中删除购物车的商品数据 如果用户此时已经登录则需要同步删除redis中额数据
        return IMOOCJSONResult.ok();

    }
}
