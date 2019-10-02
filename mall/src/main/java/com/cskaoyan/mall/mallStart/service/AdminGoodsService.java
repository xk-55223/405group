package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Goods;
import com.cskaoyan.mall.mallStart.bean.GoodsCategoryBean;
import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.UpdateGoodsInfo;

import java.util.List;

public interface AdminGoodsService {
    //商品列表
    ListBean listGoods(int page, int limit, Integer goodsSn, String name, String add, String order);

    //商品类目
    List<GoodsCategoryBean> carAndBrand();

    //商品品牌
    List<GoodsCategoryBean> goodsBrand();

    //根据id获取商品信息
    UpdateGoodsInfo goodInfo(int id);

    void goodsDelete(int id);

    ListBean commentList(int page,Integer userId,Integer valueId,int limit,String sort,String order);
}
