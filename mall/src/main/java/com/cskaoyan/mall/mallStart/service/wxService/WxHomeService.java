package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.GoodsCount;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();
}
