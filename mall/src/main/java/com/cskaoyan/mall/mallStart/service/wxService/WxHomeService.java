package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;


import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    Map selectBrandAll(BrandPageInfo pageInfo);

    Map selectBrandById(int id);

    Map selectTopicAll(BrandPageInfo pageInfo);

    SearchIndexInfo searchIndex(int userId);

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(int userId, String keyword, FromPageInfo info, int categoryId);

    void searchClearhistory(int userId);

}
