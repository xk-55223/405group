package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CartCheckedBean {
    boolean isChecked;
    List<Integer> productIds;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
