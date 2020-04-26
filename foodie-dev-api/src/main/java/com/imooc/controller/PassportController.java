package com.imooc.controller;

import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.service.impl.UserServiceImpl;
import com.imooc.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passport")
public class PassportController {
   @Autowired
   private  UserService userService;

   @GetMapping("/userIsExist")
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




}
