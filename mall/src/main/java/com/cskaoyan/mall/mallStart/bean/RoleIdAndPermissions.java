package com.cskaoyan.mall.mallStart.bean;

import java.util.List;

public class RoleIdAndPermissions {
    private int roleId;
    private String[] permissions;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}
