package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username, @Param("mobile") String mobile);

    List<AddressRegion> selectAddressAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name, @Param("userId") Integer userId);

    List<Collect> selectCollectAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("valueId") Integer valueId);

    List<Footprint> selectFootprintAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    List<SearchHistory> selectSearchHistoryAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("keyword") String keyword);

    List<Feedback> selectFeedbackAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("id") Integer id, @Param("username") String username);
}
