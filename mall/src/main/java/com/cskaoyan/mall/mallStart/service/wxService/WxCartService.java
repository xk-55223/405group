package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;

public interface WxCartService {
    //显示购物车
    CartListBean cartList(Integer id);
    //更新购物车
    void cartUpdate(Cart cart);
    //删除购物车商品
    CartListBean cartDelete(List<Integer> productIds,Integer userId);
    //勾选商品
    CartListBean cartChecked(CartCheckedBean productIds,Integer userId);

    CartCheckoutInfo cartCheckout(Integer userId, CheckoutInfo checkoutInfo);
}
