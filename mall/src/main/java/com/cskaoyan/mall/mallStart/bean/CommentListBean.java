package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CommentListBean {
    @Override
    public String toString() {
        return "CommentListBean{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }

    private int count;
    private List<CommentBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CommentBean> getData() {
        return data;
    }

    public void setData(List<CommentBean> data) {
        this.data = data;
    }
}
