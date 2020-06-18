package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "登录注册" ,tags="用于登录注册的接口")
@RestController
@RequestMapping("/passport")
public class PassportController {
   @Autowired
   private  UserService userService;
   @ApiOperation(value = "用户是否存在",notes = "用户是否存在",httpMethod = "GET")
   @GetMapping("/usernameIsExist")
   public IMOOCJSONResult usernameIsExist(@RequestParam String username) {
       /**
        * 用户名不能为空
        */
       if (StringUtils.isBlank(username)) {
        return IMOOCJSONResult.errorMsg("用户名不能为空") ;
       }
       /***
        * 用户名是否存在
        */
       boolean  isExist =  userService.queryUsernameIsExist(username);
       if(isExist){
           return IMOOCJSONResult.errorMsg("用户名已经存在");
       }
       return IMOOCJSONResult.ok();
   }
    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/regist")
   public IMOOCJSONResult regist(@RequestBody UserBO userBO) {
       //1.校验用户名，密码，确认密码是否为空
       String username = userBO.getUsername();
       String password = userBO.getPassword();
       String confirmPassword = userBO.getConfirmPassword();


       if (StringUtils.isBlank(username)||StringUtils.isBlank(password)||
               StringUtils.isBlank(confirmPassword)) {
           return IMOOCJSONResult.errorMsg("用户名或者密码不能为空");
       }
       //2.检验密码是不是小于6位
       if (password.length()<6) {
           return IMOOCJSONResult.errorMsg("密码不能小于6位");
       }
       //3.检验密码和确认密码是否一致
       if (!password.equals(confirmPassword)) {
           return IMOOCJSONResult.errorMsg("密码和确认密码不一致");
       }
       //4.校验用户名是否已经存在
       boolean isExist = userService.queryUsernameIsExist(userBO.getUsername());
       if (isExist) {
           return IMOOCJSONResult.errorMsg("用户名已经存在");
       }

       userService.CreateUser(userBO);

        return IMOOCJSONResult.ok();
   }


    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.校验用户名，密码，确认密码是否为空
        String username = userBO.getUsername();
        String password = MD5Utils.getMD5Str(userBO.getPassword());

        if (StringUtils.isBlank(username)||StringUtils.isBlank(password)) {
            return IMOOCJSONResult.errorMsg("用户名或者密码不能为空");
        }
        //
        Users result = userService.queryUserForLogin(username,password);
        if (result == null) {
            return IMOOCJSONResult.errorMsg("用户名不存咋或者密码错误请检查");
        }
        Users user = setUserNull(result);
        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(user),true);
        //TODO 生成用户token 存入redis会话
        //TODO 同步购物车数据
        return IMOOCJSONResult.ok(user);

    }
    private Users setUserNull(Users result){
        result.setUpdatedTime(null);
        result.setBirthday(null);
        result.setCreatedTime(null);
        result.setId(null);
        result.setPassword(null);
        return result;
    }
}
