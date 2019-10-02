package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface AdminSystemService {
    ListBean<Admin> selectAdminAll(FromPageInfo pageInfo, String username);

    List<RoleOptions> selectRoleOptionsAll();

    ListBean<Log> selectLogAll(FromPageInfo pageInfo, String name);

    ListBean<Role> selectRoleAll(FromPageInfo pageInfo, String name);

    Role insertRole(Role role);

    int deleteRole(Role role);

    int updateRole(Role role);

    ListBean<Storage> selectStorageAll(FromPageInfo pageInfo, String key, String name);

    Storage insertStorage(MultipartFile file) throws IOException;

    Storage updateStorage(Storage storage);
}
