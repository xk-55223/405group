package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminSystemMapper {
    List<Admin> selectAdminAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username);

    List<RoleOptions> selectRoleOptionsAll();

    List<Log> selectLogAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name);

    List<Role> selectRoleAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name);

    int insertRole(@Param("role")Role role);

    int deleteRole(@Param("role")Role role);

    int updateRole(@Param("role")Role role);
}
