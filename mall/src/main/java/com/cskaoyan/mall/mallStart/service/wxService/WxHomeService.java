package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.GoodsCount;
import com.cskaoyan.mall.mallStart.bean.GoodsListInfo;
import com.cskaoyan.mall.mallStart.bean.SearchIndexInfo;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    SearchIndexInfo searchIndex();

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(String keyword, PageInfo info, int categoryId);
}
