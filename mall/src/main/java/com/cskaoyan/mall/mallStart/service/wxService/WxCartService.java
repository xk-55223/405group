package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Cart;
import com.cskaoyan.mall.mallStart.bean.CartCheckedBean;
import com.cskaoyan.mall.mallStart.bean.CartListBean;

import java.util.List;

public interface WxCartService {
    //显示购物车
    CartListBean cartList();
    //更新购物车
    void cartUpdate(Cart cart);
    //删除购物车商品
    CartListBean cartDelete(List<Integer> productIds);
    //勾选商品
    CartListBean cartChecked(CartCheckedBean productIds);
}
