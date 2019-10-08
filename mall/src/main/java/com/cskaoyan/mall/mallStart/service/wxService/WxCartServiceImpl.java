package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxCartMapper;
import com.cskaoyan.mall.mallStart.tool.CharUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.lang.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;

@Service
public class WxCartServiceImpl implements WxCartService{
    @Autowired
    WxCartMapper wxCartMapper;

    @Autowired
    AdminGoodsMapper goodsMapper;

    @Autowired
    AdminUserMapper userMapper;

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
        CartCheckoutInfo cartCheckoutInfo = new CartCheckoutInfo();
        Address address = wxCartMapper.selectAddressById(checkoutInfo.getAddressId());
        cartCheckoutInfo.setAddressId(checkoutInfo.getAddressId());
        cartCheckoutInfo.setCheckedAddress(address);
        Integer cartId = checkoutInfo.getCartId();
        List<Cart> cart = wxCartMapper.selectCartCheckout(userId,cartId);
        double goodsTotalPrice = 0.0;
        for (Cart cartMessage : cart) {
            goodsTotalPrice += cartMessage.getNumber().intValue() * cartMessage.getPrice().doubleValue();
        }
        cartCheckoutInfo.setGoodsTotalPrice(BigDecimal.valueOf(goodsTotalPrice));
        List<CheckGoodsList> checkGoodsLists = wxCartMapper.selectCheckedGoodsLists(userId);
        cartCheckoutInfo.setCheckedGoodsList(checkGoodsLists);
        cartCheckoutInfo.setCouponId(checkoutInfo.getCouponId());
        int count = wxCartMapper.selectAvailableCouponLength(userId,goodsTotalPrice);
        cartCheckoutInfo.setAvailableCouponLength(count);
        BigDecimal couponPrice = wxCartMapper.selectCouponPrice(checkoutInfo.getCouponId(),userId);
        if (couponPrice == null) {
            couponPrice = BigDecimal.valueOf(0);
        }
        cartCheckoutInfo.setCouponPrice(couponPrice);
        cartCheckoutInfo.setGrouponRulesId(checkoutInfo.getGrouponRulesId());
        BigDecimal discount = wxCartMapper.selectGrouponPrice(checkoutInfo.getGrouponRulesId());
        if (discount == null) {
            discount = BigDecimal.valueOf(0);
        }
        cartCheckoutInfo.setGrouponPrice(discount);
        int freightPrice = 0;
        cartCheckoutInfo.setFreightPrice(freightPrice);
        BigDecimal orderTotalPrice = BigDecimal.valueOf(goodsTotalPrice - couponPrice.doubleValue());
        cartCheckoutInfo.setOrderTotalPrice(orderTotalPrice);
        cartCheckoutInfo.setActualPrice(orderTotalPrice);
        return cartCheckoutInfo;
    }

    public List<Coupon> couponSelectList(Integer userId) {
        List<Coupon> coupons = wxCartMapper.selectCouponListByUserId(userId);
        return coupons;
    }

    public int orderSubmit(OrderSubmitInfo submitInfo, Integer userId) {
        Address address = wxCartMapper.selectAddressById(submitInfo.getAddressId());
        BigDecimal goodsPrice = BigDecimal.valueOf(0);
        List<Cart> carts = null;
        if (submitInfo.getCartId() == 0) {
            carts = wxCartMapper.selectUserCheckedCarts(userId);
            for (Cart cart : carts) {
                goodsPrice = BigDecimal.valueOf(goodsPrice.doubleValue() +  cart.getPrice().doubleValue());
            }
        } else {
            Cart cart = wxCartMapper.selectCartInfoByCartId(submitInfo.getCartId());
            carts = new ArrayList();
            carts.add(cart);
            goodsPrice = cart.getPrice();
        }
        BigDecimal couponPrice = wxCartMapper.selectCouponPrice(submitInfo.getCouponId(),userId);
        if (couponPrice == null) {
            couponPrice = BigDecimal.valueOf(0);
        }
        BigDecimal discount = wxCartMapper.selectGrouponPrice(submitInfo.getGrouponRulesId());
        if (discount == null) {
            discount = BigDecimal.valueOf(0);
        }
        // 添加一个订单， 订单状态为未付款
        Order order = new Order();
        order.setOrderStatus((short) 101);
        order.setUserId(userId);
        order.setOrderSn(CharUtil.getRandomNum(10));
        User user = userMapper.selectUserInfoByUserId(userId);
        order.setConsignee(user.getNickname());
        order.setMobile(user.getMobile());
        order.setAddress(address.getAddress());
        order.setMessage(submitInfo.getMessage());
        order.setGoodsPrice(goodsPrice);
        order.setFreightPrice(BigDecimal.valueOf(0));
        order.setCouponPrice(couponPrice);
        BigDecimal integralPrice = BigDecimal.valueOf(0);
        order.setIntegralPrice(integralPrice);
        order.setGrouponPrice(discount);
        BigDecimal orderTotalPrice = BigDecimal.valueOf(goodsPrice.doubleValue() - couponPrice.doubleValue());
        order.setOrderPrice(orderTotalPrice);
        order.setActualPrice(BigDecimal.valueOf(orderTotalPrice.doubleValue() - integralPrice.doubleValue()));
        order.setPayId("1");
        order.setPayTime(new Date());
        order.setShipSn("");
        Date date = new Date();
        order.setAddTime(date);
        order.setConfirmTime(date);
        order.setUpdateTime(date);
        wxCartMapper.insertOrder(order);
        for (Cart cart : carts) {
            wxCartMapper.insertOrderGoods(cart,new Date(),order.getId());
            wxCartMapper.deleteCartById(cart.getId());
        }

        return order.getId();
    }
}
