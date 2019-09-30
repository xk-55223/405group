package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.service.AdminMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminMallController {

    @Autowired
    AdminMallService service;

    @RequestMapping("admin/region/list")
    public BaseRespVo regionlist() {
        List<Region> regions = service.selectRegions();
        BaseRespVo result = BaseRespVo.ok(regions);
        return result;
    }

    @RequestMapping("admin/brand/list")
    public BaseRespVo beandList(int page, int limit, String sort, String order) {
        service.
        BaseRespVo result = BaseRespVo.ok(regions);
        return result;
    }
}
