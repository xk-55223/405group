package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Collect;
import com.cskaoyan.mall.mallStart.bean.FromPageInfo;
import com.cskaoyan.mall.mallStart.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username, @Param("mobile") String mobile);

    List<AddressRegion> selectAddressAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name, @Param("userId") Integer userId);

    List<Collect> selectCollectAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("valueId") Integer valueId);
}
