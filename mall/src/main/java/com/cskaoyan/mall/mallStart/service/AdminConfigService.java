package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.LiteMallExpress;
import com.cskaoyan.mall.mallStart.bean.LiteMallMall;
import com.cskaoyan.mall.mallStart.bean.LiteMallOrder;
import com.cskaoyan.mall.mallStart.bean.LiteMallWx;

public interface AdminConfigService {
    LiteMallExpress selectLiteMallExpress();

    LiteMallMall selectLiteMallMall();

    void updateLiteMallMall(LiteMallMall mallConfig);

    void updateLiteMallExpress(LiteMallExpress mallConfig);

    LiteMallOrder selectLiteMallOrder();

    void updateLiteMallOrder(LiteMallOrder orderConfig);

    LiteMallWx selectLiteMallWx();

    void updateLiteMallWx(LiteMallWx wxConfig);
}
