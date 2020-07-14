package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Orders;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.pojo.vo.OrderStatusCountsVO;
import com.imooc.resource.FileUpload;
import com.imooc.service.center.CenterUserService;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户中心我的订单", tags = {"用户中心我的订单"})
@RestController
@RequestMapping("myorders")
public class MyOrdersController extends BaseController {

    @Autowired
    private MyOrdersService myOrdersService;


    @ApiOperation(value = "查询订单列表", notes = "查询订单列表", httpMethod = "POST")
    @GetMapping("/query")
    public IMOOCJSONResult comments(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderStatus",value = "订单状态",required = false)
            @RequestParam Integer orderStatus,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页记录数",required = false)
            @RequestParam Integer pageSize ){


        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult grid = myOrdersService.queryMyOrders(userId,orderStatus,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }


    /**
     *  商家发货没有后端，所以这个接口仅仅只是用于模拟
     */
    @ApiOperation(value="商家发货", notes="商家发货", httpMethod = "GET")
    @GetMapping("/deliver")
    public IMOOCJSONResult deliver(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId) throws Exception {

        if (StringUtils.isBlank(orderId)) {
            return IMOOCJSONResult.errorMsg("订单ID不能为空");
        }
        myOrdersService.updateDeliverOrderStatus(orderId);
        return IMOOCJSONResult.ok();
    }


    @ApiOperation(value="买家确认收货", notes="买家确认收货", httpMethod = "POST")
    @PostMapping("/confirmReceive")
    public IMOOCJSONResult confirmReceive(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId,
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) throws Exception {

       IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if (checkResult.getStatus()!= HttpStatus.OK.value()) {
            return checkResult;
        }
        boolean res = myOrdersService.updateReceiverOrderStatus(orderId);
        if (!res) {
            return IMOOCJSONResult.errorMsg("订单确认收货失败");
        }
      return  IMOOCJSONResult.ok();
    }




    @ApiOperation(value="用户删除订单", notes="用户删除订单", httpMethod = "POST")
    @PostMapping("/delete")
    public IMOOCJSONResult delete(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId,
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId
    ) throws Exception {

        IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if (checkResult.getStatus()!= HttpStatus.OK.value()) {
            return checkResult;
        }
        boolean res = myOrdersService.deleteOrder(userId,orderId);
        if (!res) {
            return IMOOCJSONResult.errorMsg("订单删除失败");
        }
        return  IMOOCJSONResult.ok();

    }


     @ApiOperation(value="获得订单状态数", notes="获得订单状态数", httpMethod = "POST")
    @PostMapping("/statusCounts")
    public IMOOCJSONResult delete(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId
    ) throws Exception {
         if (StringUtils.isBlank(userId)) {
             return IMOOCJSONResult.errorMsg("用户id不能为空");
         }

         OrderStatusCountsVO orderStatusCountsVO = myOrdersService.getOrderStatusCounts(userId);

        return  IMOOCJSONResult.ok(orderStatusCountsVO);

    }


    @ApiOperation(value = "查询订单动向", notes = "查询订单动向", httpMethod = "POST")
    @GetMapping("/trend")
    public IMOOCJSONResult trend(
            @ApiParam(name = "userId",value = "用户id",required = true)
            @RequestParam String userId,
            @ApiParam(name = "page",value = "查询下一页的第几页",required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize",value = "分页的每一页记录数",required = false)
            @RequestParam Integer pageSize ){


        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg(null);
        }
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult grid = myOrdersService.getOrdersTrend(userId,page,pageSize);

        return IMOOCJSONResult.ok(grid);
    }


}
