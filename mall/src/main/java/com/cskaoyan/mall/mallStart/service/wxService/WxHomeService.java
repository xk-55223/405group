package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    Map selectBrandAll(BrandPageInfo pageInfo);

    Map selectBrandById(int id);

    Map selectGoodsAll(BrandPageInfo pageInfo, int brandId);
}
