package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class WxGoodsDetail {
    @Override
    public String toString() {
        return "WxGoodsDetail{" +
                "attribute=" + attribute +
                ", brand=" + brand +
                ", comment=" + comment +
                ", groupon=" + groupon +
                ", info=" + info +
                ", shareImage='" + shareImage + '\'' +
                ", issue=" + issue +
                ", productList=" + productList +
                ", specificationList=" + specificationList +
                ", userHasCollect=" + userHasCollect +
                '}';
    }

    private List<GoodsAttribute> attribute;
    private Brand brand;
    private CommentListBean comment;
    private List<GrouponRules> groupon;
    private Goods info;

    public CommentListBean getComment() {
        return comment;
    }

    public void setComment(CommentListBean comment) {
        this.comment = comment;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    private String shareImage;
    private List<Issue> issue;
    private List<GoodsProduct> productList;
    private List<GoodsSpecificationBean> specificationList;
    private int userHasCollect;

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

    public List<GoodsSpecificationBean> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<GoodsSpecificationBean> specificationList) {
        this.specificationList = specificationList;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
