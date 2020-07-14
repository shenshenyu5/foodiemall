package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.enums.YesOrNo;
import com.imooc.pojo.OrderItems;
import com.imooc.pojo.Orders;
import com.imooc.pojo.bo.center.OrderItemsCommentBO;
import com.imooc.service.center.MyCommentsService;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户中心我的评价", tags = {"用户中心我的评价"})
@RestController
@RequestMapping("mycomments")
public class MyCommentsController extends BaseController {

    @Autowired
    private MyCommentsService myCommentsService;


    @ApiOperation(value = "保存评论列表", notes = "保存评论列表", httpMethod = "POST")
    @GetMapping("/saveList")
    public IMOOCJSONResult saveList(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderId",value = "订单id",required = true)
            @RequestParam String orderId,
            @RequestBody List<OrderItemsCommentBO> commentList
           ){
        //判断用户和订单是否关联
        IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if (checkResult.getStatus()!= HttpStatus.OK.value()) {
            return checkResult;
        }
        //判断评论内容list不能为空
        if (commentList==null||commentList.isEmpty()||commentList.size()==0) {
            return IMOOCJSONResult.errorMsg("评论内容不能为空");

        }

        myCommentsService.saveComments(orderId,userId,commentList);
        return IMOOCJSONResult.ok();
    }


    @ApiOperation(value = "查询订单列表", notes = "查询订单列表", httpMethod = "POST")
    @GetMapping("/pending")
    public IMOOCJSONResult comments(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderId",value = "订单id",required = true)
            @RequestParam String orderId
    ){
        //判断用户和订单是否关联
        IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if (checkResult.getStatus()!= HttpStatus.OK.value()) {
            return checkResult;
        }

        List<OrderItems> list =  myCommentsService.queryPendingComments(orderId);
        return IMOOCJSONResult.ok(list);
    }


}
