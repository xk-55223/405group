package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.service.AdminStatisticsSevice;
import com.cskaoyan.mall.mallStart.service.AdminSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminStatisticsController {
    @Autowired
    AdminStatisticsSevice adminStatisticsSevice;

    @RequestMapping("admin/stat/order")
    public BaseRespVo statOrder(){
        adminStatisticsSevice.statOrder();
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }
}