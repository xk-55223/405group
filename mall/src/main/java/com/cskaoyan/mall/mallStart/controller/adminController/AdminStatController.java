package com.cskaoyan.mall.mallStart.controller.adminController;


import com.cskaoyan.mall.mallStart.service.adminService.AdminStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminStatController {
    @Autowired
    AdminStatService service;

    /*@RequestMapping("admin/stat/user")
    public BaseRespVo statUser() {

    }*/
}
