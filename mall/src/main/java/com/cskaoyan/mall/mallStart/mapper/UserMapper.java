package com.cskaoyan.mall.mallStart.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select username from cskaoyan_mall_user where id = #{id}")
    public String selectUsernameById(int id);
}
