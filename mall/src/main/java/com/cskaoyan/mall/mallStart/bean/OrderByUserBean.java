package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class OrderByUserBean {
    List<OrderByUser> data;
    long count;
    int totalPages;

    public List<OrderByUser> getData() {
        return data;
    }

    public void setData(List<OrderByUser> data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
