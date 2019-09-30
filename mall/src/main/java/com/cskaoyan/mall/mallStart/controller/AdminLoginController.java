package com.cskaoyan.mall.mallStart.controller;


import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminLoginController {

    @RequestMapping("auth/login")
    public BaseRespVo login(@RequestBody User user) {
        BaseRespVo baseRespVo = BaseRespVo.ok("8098d3c8-06a9-4136-985f-844459cda183");
        return baseRespVo;
    }

    @RequestMapping("auth/info")
    public BaseRespVo info(String token) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ArrayList perms = new ArrayList();
        perms.add("*");
        loginInfo.setPerms(perms);
        ArrayList roles = new ArrayList();
        roles.add("超级管理员");
        loginInfo.setRoles(roles);
        loginInfo.setName("admin123");
        BaseRespVo baseRespVo = BaseRespVo.ok(loginInfo);
        return baseRespVo;
    }
}
