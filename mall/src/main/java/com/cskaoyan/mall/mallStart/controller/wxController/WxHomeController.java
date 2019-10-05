package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.GoodsCount;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxHomeController {
    @Autowired
    WxHomeService service;


    @RequestMapping("wx/home/index")
    public BaseRespVo homeIndex() {
        WxIndexInfo wxIndexInfo = service.homeIndex();
        return BaseRespVo.ok(wxIndexInfo);
    }

    @RequestMapping("wx/goods/count")
    public BaseRespVo goodsCount() {
        GoodsCount goodsCount = service.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }
}
