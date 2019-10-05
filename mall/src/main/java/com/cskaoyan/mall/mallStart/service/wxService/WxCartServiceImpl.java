package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Cart;
import com.cskaoyan.mall.mallStart.bean.CartListBean;
import com.cskaoyan.mall.mallStart.bean.CartTotal;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCartServiceImpl implements WxCartService{
    @Autowired
    WxCartMapper wxCartMapper;

    @Override
    public CartListBean cartList() {
        List<Cart> cartList = wxCartMapper.CartList();
        CartListBean cartListBean = new CartListBean();
        CartTotal cartTotal = new CartTotal();
        double goodsAmount = 0;
        int goodsCount = 0;
        int checkedGoodsCount = 0;
        double checkedGoodsAmount = 0;
        for (Cart cart : cartList) {
            goodsAmount += cart.getPrice().doubleValue() * cart.getNumber();
            goodsCount += cart.getNumber();
            if(cart.getChecked()==true){
                checkedGoodsCount++;
                checkedGoodsAmount += cart.getPrice().doubleValue() * cart.getNumber();
            }
        }
        cartTotal.setGoodsCount(goodsCount);
        cartTotal.setCheckedGoodsCount(checkedGoodsCount);
        cartTotal.setGoodsAmount(goodsAmount);
        cartTotal.setCheckedGoodsAmount(checkedGoodsAmount);
        cartListBean.setCartTotal(cartTotal);
        cartListBean.setCartList(cartList);
        return cartListBean;
    }
}
