package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CouponBeanList {
    List<Coupon> items;
    Long total;

    public List<Coupon> getItems() {
        return items;
    }

    public void setItems(List<Coupon> items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
