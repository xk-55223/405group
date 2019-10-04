package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class SystemPermissions {
    private List<Object> children;
    private String id;
    private String label;

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
