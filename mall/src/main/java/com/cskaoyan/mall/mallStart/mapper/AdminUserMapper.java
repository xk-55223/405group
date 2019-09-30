package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("add_time")String add_time,@Param("order")String order);
}
