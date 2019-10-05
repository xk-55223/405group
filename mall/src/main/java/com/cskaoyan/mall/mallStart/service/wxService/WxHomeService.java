package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    SearchIndexInfo searchIndex();

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(String keyword, FromPageInfo info, int categoryId);
}
