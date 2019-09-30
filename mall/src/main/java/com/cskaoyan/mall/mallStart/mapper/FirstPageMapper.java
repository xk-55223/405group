package com.cskaoyan.mall.mallStart.mapper;

import org.apache.ibatis.annotations.Select;

public interface FirstPageMapper {

    @Select("select count(id) from cskaoyan_mall_user ")
    public int getUserTotal();

    @Select("select count(id) from cskaoyan_mall_goods ")
    public int getGoodsTotal();

    @Select("select count(id) from cskaoyan_mall_goods_product")
    public int getProductTotal();

    @Select("select count(id) from cskaoyan_mall_order")
    public int getOrderTotal();
}
