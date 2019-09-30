package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CategoryAndBrandBean {
    List<GoodsCategoryBean> categoryList;
    List<GoodsCategoryBean> brandList;

    public List<GoodsCategoryBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<GoodsCategoryBean> categoryList) {
        this.categoryList = categoryList;
    }

    public List<GoodsCategoryBean> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<GoodsCategoryBean> brandList) {
        this.brandList = brandList;
    }
}
