package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

// 用于封装brand库的分页信息
public class BrandList {
    private int total;
    private List<Brand> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Brand> getItems() {
        return items;
    }

    public void setItems(List<Brand> items) {
        this.items = items;
    }
}
