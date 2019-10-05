package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;


import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    SearchIndexInfo searchIndex(int userId);

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(int userId, String keyword, FromPageInfo info, int categoryId);
    Map selectBrandAll(FromPageInfo pageInfo);

    void searchClearhistory(int userId);
}
