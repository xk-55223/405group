package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.config.FileUpConfig;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class AdminSystemServiceImpl implements AdminSystemService {
    @Autowired
    AdminSystemMapper adminSystemMapper;
    @Autowired
    FileUpConfig fileUpConfig;
    @Autowired
    ResourceProperties resourceProperties;

    @Override
    public ListBean<Admin> selectAdminAll(FromPageInfo pageInfo, String username) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Admin> admins = adminSystemMapper.selectAdminAll(pageInfo, username);
        return new BeansManager<Admin>().toListBean(admins);
    }

    @Override
    public List<RoleOptions> selectRoleOptionsAll() {
        return adminSystemMapper.selectRoleOptionsAll();
    }

    @Override
    public ListBean<Log> selectLogAll(FromPageInfo pageInfo, String name) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Log> logs = adminSystemMapper.selectLogAll(pageInfo, name);
        return new BeansManager<Log>().toListBean(logs);
    }

    @Override
    public ListBean<Role> selectRoleAll(FromPageInfo pageInfo, String name) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Role> roles = adminSystemMapper.selectRoleAll(pageInfo, name);
        return new BeansManager<Role>().toListBean(roles);
    }

    @Override
    public Role insertRole(Role role) {
        role.setAddTime(new Date());
        role.setUpdateTime(new Date());
        adminSystemMapper.insertRole(role);
        return role;
    }

    @Override
    public int deleteRole(Role role) {
        return adminSystemMapper.deleteRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return adminSystemMapper.updateRole(role);
    }

    @Override
    public ListBean<Storage> selectStorageAll(FromPageInfo pageInfo, String key, String name) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Storage> storages = adminSystemMapper.selectStorageAll(pageInfo, key, name);
        for (Storage storage : storages) {
            storage.setUrl(fileUpConfig.getLocalhost() + storage.getUrl());
        }
        return new BeansManager<Storage>().toListBean(storages);
    }

    @Override
    public Storage insertStorage(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String key = UUID.randomUUID().toString().replaceAll("-", "") + "." + split[split.length - 1];
        String path = resourceProperties.getStaticLocations()[0].replace("file:", "") + fileUpConfig.getFilepath();
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String url = fileUpConfig.getFilepath() + key;
        File toTargetFile = new File(path + key);
        file.transferTo(toTargetFile);
        Storage storage = new Storage(key, originalFilename, file.getContentType(), (int) file.getSize(), url, new Date(), new Date());
        adminSystemMapper.insertStorage(storage);
        storage.setUrl(fileUpConfig.getLocalhost() + url);
        return storage;
    }

    @Override
    public Storage updateStorage(Storage storage) {
        storage.setUpdateTime(new Date());
        adminSystemMapper.updateStorage(storage);
        return storage;
    }

    @Override
    public int deleteStorage(Storage storage) {
        return adminSystemMapper.deleteStorage(storage);
    }

    @Override
    public Admin insertAdmin(Admin admin) {
        admin.setAddTime(new Date());
        admin.setUpdateTime(new Date());
        adminSystemMapper.insertAdmin(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        admin.setUpdateTime(new Date());
        adminSystemMapper.updateAdmin(admin);
        return admin;
    }

    @Override
    public int deleteAdmin(Admin admin) {
        return adminSystemMapper.deleteAdmin(admin);
    }

}
