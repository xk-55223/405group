package com.cskaoyan.mall.mallStart.bean;

public class OrderSubmitInfo {
    private Integer addressId;
    private Integer cartId;
    private Integer couponId;
    private Integer grouponLinkId;
    private Integer grouponRulesId;
    private String message;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getGrouponLinkId() {
        return grouponLinkId;
    }

    public void setGrouponLinkId(Integer grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
    }

    public Integer getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(Integer grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
