package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.Log;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;

import java.util.List;

public interface AdminFirstPageService {
    DashBoard getDashBorad();

    LoginInfo selectLoginInfoByUsername(String username);

    void addLog(Log log, Admin admin);

    void addLoginoutLog(Log log);
}
