package com.cskaoyan.mall.mallStart.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OrderByUser {
    String orderStatusText;
    boolean isGroupin;
    String OrderSn;
    double actualPrice;
    List<OrderGoods> goodsList;
    int id;
    HandleOption handleOption;
    double grouponPrice;
    String comments;
    boolean deleted;
    int orderStatus;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Date confireTime;

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public boolean getIsGroupin() {
        return isGroupin;
    }

    public void setIsGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public String getOrderSn() {
        return OrderSn;
    }

    public void setOrderSn(String orderSn) {
        OrderSn = orderSn;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getConfireTime() {
        return confireTime;
    }

    public void setConfire_time(Date confireTime) {
        this.confireTime = confireTime;
    }

}
