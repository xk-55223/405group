package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;


public interface AdminSystemService {
    ListBean<Admin> selectAdminAll(FromPageInfo pageInfo, String username);

    List<RoleOptions> selectRoleOptionsAll();
}