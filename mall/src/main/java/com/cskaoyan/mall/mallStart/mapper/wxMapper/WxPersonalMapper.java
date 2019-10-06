package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import org.apache.ibatis.annotations.Select;

public interface WxPersonalMapper {
    @Select("select order_status from cskaoyan_mall_order ")
    int[] selectOrderStatusId();
}
