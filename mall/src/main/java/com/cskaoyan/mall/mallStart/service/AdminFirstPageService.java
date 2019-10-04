package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.DashBoard;

import java.util.List;

public interface AdminFirstPageService {
    public DashBoard getDashBorad();

    String selectAvatarByUserName(String username);

    List<String> selectRolesByUsername(String username);

    List<String> selectPermissionByUserName(String username);
}
