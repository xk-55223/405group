package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class ListBean<T> {
    int total;
    List<T> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
