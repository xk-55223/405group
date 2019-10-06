package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class WxHomeController {
    @Autowired
    WxHomeService wxHomeService;


    @RequestMapping("wx/home/index")
    public BaseRespVo homeIndex() {
        WxIndexInfo wxIndexInfo = wxHomeService.homeIndex();
        return BaseRespVo.ok(wxIndexInfo);
    }

    @RequestMapping("wx/goods/count")
    public BaseRespVo goodsCount() {
        GoodsCount goodsCount = wxHomeService.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }

    /*ljq*/
    @RequestMapping("wx/brand/list")
    public BaseRespVo<Map> brandList(BrandPageInfo pageInfo) {
        Map resultMap = wxHomeService.selectBrandAll(pageInfo);
        return BaseRespVo.ok(resultMap);
    }

    /*ljq*/
    @RequestMapping("wx/brand/detail")
    public BaseRespVo<Map> brandDetail(int id) {
        Map resultMap = wxHomeService.selectBrandById(id);
        return BaseRespVo.ok(resultMap);
    }
    /*ljq*/
    @RequestMapping("wx/goods/list")
    public BaseRespVo<Map> goodsList(BrandPageInfo pageInfo,int brandId) {
        Map result = wxHomeService.selectGoodsAll(pageInfo,brandId);
        return BaseRespVo.ok(result);
    }
}
