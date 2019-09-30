package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.PageInfo;

public interface AdminUserService {
    ListBean<User> selectUserAll(PageInfo userInfo,String username,String mobile);
}
