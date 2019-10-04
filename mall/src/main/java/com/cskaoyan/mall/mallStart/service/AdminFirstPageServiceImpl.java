package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;
import com.cskaoyan.mall.mallStart.mapper.AdminFirstPageMapper;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminFirstPageServiceImpl implements AdminFirstPageService {

    @Autowired
    AdminFirstPageMapper firstPageMapper;
    @Autowired
    AdminSystemMapper adminSystemMapper;

    @Override
    public DashBoard getDashBorad() {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setGoodsTotal(firstPageMapper.getGoodsTotal());
        dashBoard.setOrderTotal(firstPageMapper.getOrderTotal());
        dashBoard.setUserTotal(firstPageMapper.getUserTotal());
        dashBoard.setProductTotal(firstPageMapper.getProductTotal());
        return dashBoard;
    }

    @Override
    public LoginInfo selectLoginInfoByUsername(String username) {
        Admin admin = adminSystemMapper.selectAdminByUsername(username);
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(admin.getUsername());
        loginInfo.setAvatar(admin.getAvatar());
        List<String> roles = adminSystemMapper.selectRoleNamesByRolesId(admin.getRoleIds());
        loginInfo.setRoles(roles);
        List<String> perms = adminSystemMapper.selectPermsByRolesId(admin.getRoleIds());
        loginInfo.setPerms(perms);
        return loginInfo;
    }
}
