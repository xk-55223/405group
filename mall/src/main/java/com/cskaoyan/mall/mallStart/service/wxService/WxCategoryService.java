package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.WxGoodsDetail;

import java.util.List;
import java.util.Map;

public interface WxCategoryService {
    int countGoods();

    Map<String, Object> currentCatalog(int id);

    List<Category> currentCategoryList();

    WxGoodsDetail getWxGoodsDetail(int id,int userId);
}
