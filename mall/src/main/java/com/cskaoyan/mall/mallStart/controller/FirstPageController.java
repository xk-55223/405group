package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.service.FirstPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FirstPageController {
    @Autowired
    FirstPageService firstPageService;

    @RequestMapping("admin/dashboard")
    public BaseRespVo dashboard(){
        BaseRespVo<Object> result = new BaseRespVo<>();
        DashBoard dashBorad = firstPageService.getDashBorad();
        result.setData(dashBorad);
        result.setErrno(0);
        result.setErrmsg("成功");
        return result;
    }

    @RequestMapping("admin/auth/login")
    public BaseRespVo login(@RequestBody User user) {
        System.out.println(user);
        BaseRespVo<String> baseRespVo = new BaseRespVo<>();
        baseRespVo.setData("8098d3c8-06a9-4136-985f-844459cda183");
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    @RequestMapping("admin/auth/info")
    public BaseRespVo info(String token) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ArrayList perms = new ArrayList();
        perms.add("*");
        loginInfo.setPerms(perms);
        ArrayList roles = new ArrayList();
        roles.add("超级管理员");
        loginInfo.setRoles(roles);
        loginInfo.setName("admin123");
        baseRespVo.setData(loginInfo);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
