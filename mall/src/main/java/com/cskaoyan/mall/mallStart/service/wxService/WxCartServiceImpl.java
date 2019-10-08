package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WxCartServiceImpl implements WxCartService{
    @Autowired
    WxCartMapper wxCartMapper;

    @Override
    public CartListBean cartList(Integer id) {

        List<Cart> cartList = wxCartMapper.CartList(id);
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

    @Override
    public void cartUpdate(Cart cart) {
        wxCartMapper.cartUpdate(cart);
    }

    @Override
    public CartListBean cartDelete(List<Integer> productIds,Integer userId) {
        for (Integer productId : productIds) {
            wxCartMapper.cartDelete(productId);
        }
        return cartList(userId);
    }

    @Override
    public CartListBean cartChecked(CartCheckedBean productIds,Integer userId) {
        boolean checked = productIds.getIsChecked();
        List<Integer> productIds1 = productIds.getProductIds();
        for (Integer integer : productIds1) {
            wxCartMapper.changeIschecked(checked,integer);
        }

        return cartList(userId);
    }

    @Override
    public CartCheckoutInfo cartCheckout(Integer userId, CheckoutInfo checkoutInfo) {

        return null;
    }
}
