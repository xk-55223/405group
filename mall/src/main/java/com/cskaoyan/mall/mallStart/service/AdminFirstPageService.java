package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;

import java.util.List;

public interface AdminFirstPageService {
    DashBoard getDashBorad();

    LoginInfo selectLoginInfoByUsername(String username);
}
