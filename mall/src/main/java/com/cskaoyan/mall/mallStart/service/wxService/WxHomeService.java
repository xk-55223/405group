package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

<<<<<<< HEAD
=======

>>>>>>> d190f5689896654bb0635c3ff962b90982f8d109
import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

<<<<<<< HEAD
    Map selectBrandAll(BrandPageInfo pageInfo);

    Map selectBrandById(int id);

    Map selectGoodsAll(BrandPageInfo pageInfo, int brandId);
=======
    SearchIndexInfo searchIndex(int userId);

    List<String> searchHelper(String keyword);

    GoodsListInfo goodsList(int userId, String keyword, FromPageInfo info, int categoryId);
    Map selectBrandAll(FromPageInfo pageInfo);

    void searchClearhistory(int userId);
>>>>>>> d190f5689896654bb0635c3ff962b90982f8d109
}
