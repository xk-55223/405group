package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.PageInfo;


import java.util.List;

public interface AdminUserService {
    ListBean<User> selectUserAll(PageInfo userInfo, String username, String mobile);

    ListBean<AddressRegion> selectAddressAll(PageInfo userInfo, String name, int userId);
}
