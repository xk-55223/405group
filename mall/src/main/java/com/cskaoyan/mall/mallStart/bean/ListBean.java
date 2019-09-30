package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

// 商品分页操作封装
public class ListBean<T> {
    long total;
    List<T> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {

        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
