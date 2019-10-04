package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.*;

public interface AdminUserService {
    ListBean<User> selectUserAll(FromPageInfo pageInfo, String username, String mobile);

    ListBean<AddressRegion> selectAddressAll(FromPageInfo pageInfo, String name, Integer userId);

    ListBean<Collect> selectCollectAll(FromPageInfo pageInfo, Integer userId, Integer valueId);

    ListBean<Footprint> selectFootprintAll(FromPageInfo pageInfo, Integer userId, Integer goodsId);

    ListBean<SearchHistory> selectSearchHistoryAll(FromPageInfo pageInfo, Integer userId, String keyword);

    ListBean<Feedback> selectFeedbackAll(FromPageInfo pageInfo, Integer id, String username);
}
