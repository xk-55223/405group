package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;


public interface AdminSystemService {
    ListBean<Admin> selectAdminAll(FromPageInfo pageInfo, String username);

    List<RoleOptions> selectRoleOptionsAll();

    ListBean<Log> selectLogAll(FromPageInfo pageInfo, String name);

    ListBean<Role> selectRoleAll(FromPageInfo pageInfo, String name);

    Role insertRole(Role role);

    int deleteRole(Role role);
}
