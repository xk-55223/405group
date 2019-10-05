package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class WxGoodsDetail {
    private List<GoodsAttribute> attribute;
    private Brand brand;
    private ListBean<Comment> comment;
    private List<GrouponRules> groupon;
    private Goods info;
    private List<Issue> issue;
    private List<GoodsProduct> productList;
    private List<GoodsSpecificationBean> specificationLists;
    private int userHasCollect;

    @Override
    public String toString() {
        return "WxGoodsDetail{" +
                "attribute=" + attribute +
                ", brand=" + brand +
                ", comment=" + comment +
                ", groupon=" + groupon +
                ", info=" + info +
                ", issue=" + issue +
                ", productList=" + productList +
                ", specificationLists=" + specificationLists +
                ", userHasCollect=" + userHasCollect +
                '}';
    }

    public List<GoodsAttribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<GoodsAttribute> attribute) {
        this.attribute = attribute;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ListBean<Comment> getComment() {
        return comment;
    }

    public void setComment(ListBean<Comment> comment) {
        this.comment = comment;
    }

    public List<GrouponRules> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<GrouponRules> groupon) {
        this.groupon = groupon;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

    public List<GoodsProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<GoodsProduct> productList) {
        this.productList = productList;
    }

    public List<GoodsSpecificationBean> getSpecificationLists() {
        return specificationLists;
    }

    public void setSpecificationLists(List<GoodsSpecificationBean> specificationLists) {
        this.specificationLists = specificationLists;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
