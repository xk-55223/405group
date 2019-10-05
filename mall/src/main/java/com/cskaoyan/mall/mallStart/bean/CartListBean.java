package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CartListBean {
    CartTotal cartTotal;
    List<Cart> cartList;

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
