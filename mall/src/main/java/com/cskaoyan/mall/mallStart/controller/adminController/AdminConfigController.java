package com.cskaoyan.mall.mallStart.controller.adminController;


import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminConfigController {

    @Autowired
    AdminConfigService service;

    // 配置模块 查找商城配置信息
    @RequestMapping(value = "admin/config/mall", method = RequestMethod.GET)
    public BaseRespVo configMallGET() {
        LiteMallMall express = service.selectLiteMallMall();
        BaseRespVo result = BaseRespVo.ok(express);
        return result;
    }

    // 同一个接口可能调用不同的请求方法 所以分成两部分
    @RequestMapping(value = "admin/config/mall", method = RequestMethod.POST)
    public BaseRespVo configMallPOST(@RequestBody LiteMallMall mallConfig) {
        service.updateLiteMallMall(mallConfig);
        BaseRespVo result = BaseRespVo.ok(null);
        return result;
    }

    // 这两个接口和上面的情况一样，运费配置的显示和修改
    @RequestMapping(value = "admin/config/express", method = RequestMethod.GET)
    public BaseRespVo configExpress() {
        LiteMallExpress liteMallExpress = service.selectLiteMallExpress();
        BaseRespVo result = BaseRespVo.ok(liteMallExpress);
        return result;
    }

    @RequestMapping(value = "admin/config/express", method = RequestMethod.POST)
    public BaseRespVo configExpress(@RequestBody LiteMallExpress expressConfig) {
        service.updateLiteMallExpress(expressConfig);
        BaseRespVo result = BaseRespVo.ok(null);
        return result;
    }

    // 这两个接口和上面的一样，运费配置和修改
    @RequestMapping(value = "admin/config/order", method = RequestMethod.GET)
    public BaseRespVo configOrder() {
        LiteMallOrder liteMallExpress = service.selectLiteMallOrder();
        BaseRespVo result = BaseRespVo.ok(liteMallExpress);
        return result;
    }

    @RequestMapping(value = "admin/config/order", method = RequestMethod.POST)
    public BaseRespVo configOrder(@RequestBody LiteMallOrder orderConfig) {
        service.updateLiteMallOrder(orderConfig);
        BaseRespVo result = BaseRespVo.ok(null);
        return result;
    }

    // 这两个接口和上一个接口一样，小程序配置
    @RequestMapping(value = "admin/config/wx", method = RequestMethod.GET)
    public BaseRespVo configW() {
        LiteMallWx liteMallWx = service.selectLiteMallWx();
        BaseRespVo result = BaseRespVo.ok(liteMallWx);
        return result;
    }

    @RequestMapping(value = "admin/config/wx", method = RequestMethod.POST)
    public BaseRespVo configWx(@RequestBody LiteMallWx wxConfig) {
        service.updateLiteMallWx(wxConfig);
        BaseRespVo result = BaseRespVo.ok(null);
        return result;
    }
}
