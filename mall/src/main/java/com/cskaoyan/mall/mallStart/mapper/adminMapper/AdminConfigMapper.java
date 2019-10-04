package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.LiteMallExpress;
import com.cskaoyan.mall.mallStart.bean.LiteMallMall;
import com.cskaoyan.mall.mallStart.bean.LiteMallOrder;
import com.cskaoyan.mall.mallStart.bean.LiteMallWx;
import org.apache.ibatis.annotations.Param;

public interface AdminConfigMapper {

    LiteMallExpress selectLiteMallExpress();

    LiteMallMall selectLiteMallMall();

    LiteMallOrder selectLiteMallOrder();

    void updateLiteMallMall(@Param("mallConfig") LiteMallMall mallConfig);

    void updateLiteMallExpress(@Param("expressConfig") LiteMallExpress expressConfig);

    void updateLiteMallOrder(@Param("orderConfig") LiteMallOrder orderConfig);

    LiteMallWx selectLiteMallWx();

    void updateLiteMallWx(@Param("wxConfig") LiteMallWx wxConfig);
}
