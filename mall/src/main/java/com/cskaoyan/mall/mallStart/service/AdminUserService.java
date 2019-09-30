package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;

import java.util.List;

public interface AdminUserService {
    ListBean<User> selectUserAll(int page, int limit, String add_time, String order);
}
