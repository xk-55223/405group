package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class GeneralizeTopicBeanList {
    private List<Topic> items;
    private long total;

    public List<Topic> getItems() {
        return items;
    }

    public void setItems(List<Topic> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
