package com.cskaoyan.my1.demo.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select username from wd_user_t where id = #{id}")
    public String selectUsernameById(int id);
}
