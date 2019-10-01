package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;

public interface AdminUserService {
    ListBean<User> selectUserAll(FromPageInfo pageInfo, String username, String mobile);

    ListBean<AddressRegion> selectAddressAll(FromPageInfo pageInfo, String name, Integer userId);

    ListBean<Collect> selectCollectAll(FromPageInfo pageInfo, Integer userId, Integer valueId);
}
