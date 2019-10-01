package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("username") String username, @Param("mobile") String mobile);

    List<AddressRegion> selectAddressAll(@Param("name") String name, @Param("userId") int userId);
}
