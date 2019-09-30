package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class AdListBean {
    List<Ad> items;

    public List<Ad> getItems() {
        return items;
    }

    public void setItems(List<Ad> items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    Long total;
}
