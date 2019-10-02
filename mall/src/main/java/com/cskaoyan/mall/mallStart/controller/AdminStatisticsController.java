package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.StatOrderBean;
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
        StatOrderBean statOrderBean = adminStatisticsSevice.statOrder();
        BaseRespVo ok = BaseRespVo.ok("成功");
        ok.setData(statOrderBean);
        return ok;
    }

    @RequestMapping("admin/stat/user")
    public BaseRespVo statUser(){
        StatOrderBean statOrderBean = adminStatisticsSevice.statUser();
        BaseRespVo ok = BaseRespVo.ok("成功");
        ok.setData(statOrderBean);
        return ok;
    }
}
