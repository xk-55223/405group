package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CouponUserBeanList {
    List<CouponUser> items;
    long total;

    public List<CouponUser> getItems() {
        return items;
    }

    public void setItems(List<CouponUser> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
