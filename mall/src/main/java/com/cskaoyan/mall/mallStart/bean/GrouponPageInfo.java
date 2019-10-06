package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class GrouponPageInfo {
    int count;
    List<GrouponInfo> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GrouponInfo> getData() {
        return data;
    }

    public void setData(List<GrouponInfo> data) {
        this.data = data;
    }
}
