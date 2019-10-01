package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminSystemMapper {
    List<AdminTemp> selectAdminAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username);

    List<RoleOptions> selectRoleOptionsAll();
}
