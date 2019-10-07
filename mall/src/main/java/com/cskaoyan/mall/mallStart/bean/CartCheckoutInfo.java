package com.cskaoyan.mall.mallStart.bean;

import java.math.BigDecimal;
import java.util.List;

public class CartCheckoutInfo {
    BigDecimal actualPrice;
    Integer addressId;
    Integer availableCouponLength;
    Address checkedAddress;
    List<Goods> checkedGoodsList;
    Integer couponId;
    Integer couponPrice;
    Integer freightPrice;
    BigDecimal goodsTotalPrice;
    Integer grouponPrice;
    Integer grouponRulesId;
    BigDecimal orderTotalPrice;

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(Integer availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public Address getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(Address checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public List<Goods> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<Goods> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Integer couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(Integer grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public Integer getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(Integer grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
