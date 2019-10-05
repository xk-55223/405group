package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    // 搜索时显示关键词信息
    @RequestMapping("wx/search/index")
    public BaseRespVo searchIndex() {
        SearchIndexInfo indexInfo = service.searchIndex();
        return BaseRespVo.ok(indexInfo);
    }

    @RequestMapping("wx/search/helper")
    public BaseRespVo searchHelper(String keyword) {
        List<String> keywords = service.searchHelper(keyword);
        return BaseRespVo.ok(keywords);
    }

    @RequestMapping("wx/goods/list")
    public BaseRespVo goodsList(String keyword, PageInfo info,Integer categoryId) {
        GoodsListInfo goodsListInfo = service.goodsList(keyword,info,categoryId);
        return BaseRespVo.ok(goodsListInfo);
    }
}
