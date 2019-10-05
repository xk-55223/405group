package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class GoodsListInfo {
    int count;
    List<Category> filterCategoryList;
    List<Goods> goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Category> getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(List<Category> filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
