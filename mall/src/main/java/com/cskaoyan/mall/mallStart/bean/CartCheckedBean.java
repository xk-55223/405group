package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class CartCheckedBean {
    boolean isChecked;
    List<Integer> productIds;

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
