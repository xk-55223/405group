package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminSystemMapper {
    List<Admin> selectAdminAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username);

    List<RoleOptions> selectRoleOptionsAll();

    List<Log> selectLogAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name);

    List<Role> selectRoleAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name);

    int insertRole(@Param("role") Role role);

    int deleteRole(@Param("role") Role role);

    int updateRole(@Param("role") Role role);

    List<Storage> selectStorageAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("key") String key, @Param("name") String name);

    int insertStorage(@Param("storage") Storage storage);

    int updateStorage(@Param("storage") Storage storage);

    int deleteStorage(@Param("storage") Storage storage);

    int insertAdmin(@Param("admin") Admin admin);

    int updateAdmin(@Param("admin") Admin admin);

    int deleteAdmin(@Param("admin") Admin admin);

    List<String> selectRoleNamesByRolesId(@Param("roleIds") int[] roleIds);

    Admin selectAdminByUsername(@Param("username") String username);

    List<String> selectPermsByRolesId(@Param("roleIds") int[] roleIds);

    String selectPasswordByUserName(@Param("username") String username);

    List<SystemPermissions> selectSystemPermissionsAll();

    List<String> selectPermsAll();

    int deletePermsByRoleId(@Param("roleId") int roleId);

    int insertPerms(@Param("roleIdAndPermissions") RoleIdAndPermissions roleIdAndPermissions);

    String selectApisByPerm(String perm);
}
