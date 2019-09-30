package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.UserInfo;

import java.util.List;

public interface AdminUserService {
    ListBean<User> selectUserAll(UserInfo userInfo);
}
