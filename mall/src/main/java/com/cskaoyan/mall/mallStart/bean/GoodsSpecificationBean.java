package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class GoodsSpecificationBean {
    private List<GoodsSpecification> valueList;
    private String name;

    @Override
    public String toString() {
        return "GoodsSpecificationBean{" +
                "valueList=" + valueList +
                ", name='" + name + '\'' +
                '}';
    }

    public List<GoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecification> valueList) {
        this.valueList = valueList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
