package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    Map selectBrandAll(FromPageInfo pageInfo);
}
