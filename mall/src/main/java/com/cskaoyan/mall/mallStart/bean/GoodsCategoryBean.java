package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

/**
 * 商品规格
 */
public class GoodsCategoryBean {
    int value;
    String label;
    List<GoodsCategoryBean> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<GoodsCategoryBean> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCategoryBean> children) {
        this.children = children;
    }
}
