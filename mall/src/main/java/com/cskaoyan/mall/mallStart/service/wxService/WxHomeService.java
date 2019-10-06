package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;


import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    SearchIndexInfo searchIndex(int userId);

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(Integer userId, String keyword, FromPageInfo info, Integer categoryId, Integer brandId);
    Map selectBrandAll(FromPageInfo pageInfo);

    void searchClearhistory(int userId);

    GoodsCategoryInfo goodsCategory(Integer id);
}
