package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.Log;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminFirstPageMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<String> apis = new ArrayList<>();
        for (String perm : perms) {
            apis.add(adminSystemMapper.selectApisByPerm(perm));
        }
        loginInfo.setPerms(apis);
        return loginInfo;
    }

    @Override
    public void addLog(Log log,Admin admin) {
        Admin admin1 = firstPageMapper.queryAdmin(admin);
        log.setStatus(true);
        log.setAction("登陆");
        if(admin==null){
            log.setAdmin("匿名用户");
            log.setStatus(false);
            log.setAction("用户名或密码错误");
        }
        firstPageMapper.addLog(log);
    }

    @Override
    public void addLoginoutLog(Log log) {
        log.setAction("退出");
        firstPageMapper.addLog(log);
    }
}
