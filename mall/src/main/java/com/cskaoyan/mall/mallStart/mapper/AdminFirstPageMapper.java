package com.cskaoyan.mall.mallStart.mapper;

import org.apache.ibatis.annotations.Select;


public interface AdminFirstPageMapper {
    @Select("select count(id) from cskaoyan_mall_user ")
    int getUserTotal();

    @Select("select count(id) from cskaoyan_mall_goods ")
    int getGoodsTotal();

    @Select("select count(id) from cskaoyan_mall_goods_product")
    int getProductTotal();

    @Select("select count(id) from cskaoyan_mall_order")
    int getOrderTotal();

}
