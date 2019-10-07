package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class GrouponDetail {
    private User creator;
    private Groupon groupon;
    private List<User> joiners;
    private int linkGrouponId;
    private List<OrderGoods> orderGoods;
    private Order orderInfo;
    private GrouponRules rules;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public List<User> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<User> joiners) {
        this.joiners = joiners;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Order getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Order orderInfo) {
        this.orderInfo = orderInfo;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }
}
