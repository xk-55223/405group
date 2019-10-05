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

    // 搜索时显示关键词信息
    @RequestMapping("wx/search/index")
    public BaseRespVo searchIndex() {
        int userId = 1;
        SearchIndexInfo indexInfo = wxHomeService.searchIndex(userId);
        return BaseRespVo.ok(indexInfo);
    }

    @RequestMapping("wx/search/helper")
    public BaseRespVo searchHelper(String keyword) {
        List<String> keywords = wxHomeService.searchHelper(keyword);
        return BaseRespVo.ok(keywords);
    }

    @RequestMapping("wx/goods/list")
    public BaseRespVo goodsList(String keyword, FromPageInfo info,Integer categoryId) {
        int userId = 1;
        GoodsListInfo goodsListInfo = wxHomeService.goodsList(userId, keyword, info, categoryId);
        return BaseRespVo.ok(goodsListInfo);
    }
    /*ljq*/
    @RequestMapping("wx/brand/list")
    public BaseRespVo<Map> brandList(FromPageInfo pageInfo) {
        Map resultMap = wxHomeService.selectBrandAll(pageInfo);
        return BaseRespVo.ok(resultMap);
    }

    @RequestMapping("wx/search/clearhistory")
    public BaseRespVo searchClearhistory() {
        int id = 1;
        wxHomeService.searchClearhistory(id);
        return BaseRespVo.ok(null);
    }
}
