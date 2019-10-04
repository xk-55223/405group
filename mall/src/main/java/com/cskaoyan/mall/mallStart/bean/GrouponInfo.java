package com.cskaoyan.mall.mallStart.bean;

public class GrouponInfo {
    Goods goods;
    Integer groupon_member;
    Double groupon_price;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }

    public Double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(Double groupon_price) {
        this.groupon_price = groupon_price;
    }
}
