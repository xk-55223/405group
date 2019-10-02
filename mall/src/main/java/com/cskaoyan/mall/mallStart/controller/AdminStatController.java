package com.cskaoyan.mall.mallStart.controller;


import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.service.AdminStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminStatController {
    @Autowired
    AdminStatService service;

    /*@RequestMapping("admin/stat/user")
    public BaseRespVo statUser() {

    }*/
}
