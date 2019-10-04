package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class WxIndexInfo {
    List<Ad> banner;
    List<Brand> brandList;
    List<Category> channel;
    List<Coupon> couponList;
    List<Category> floorGoodsList;
    List<GrouponInfo> grouponList;
    List<Goods> hotGoods;
    List<Goods> newGoods;
    List<Topic> topicList;

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Ad> getBanner() {
        return banner;
    }

    public void setBanner(List<Ad> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getChannel() {
        return channel;
    }

    public void setChannel(List<Category> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<Category> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<Category> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public List<GrouponInfo> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<GrouponInfo> grouponList) {
        this.grouponList = grouponList;
    }

    public List<Goods> getHotGoods() {
        return hotGoods;
    }

    public void setHotGoods(List<Goods> hotGoods) {
        this.hotGoods = hotGoods;
    }

    public List<Goods> getNewGoods() {
        return newGoods;
    }

    public void setNewGoods(List<Goods> newGoods) {
        this.newGoods = newGoods;
    }
}
