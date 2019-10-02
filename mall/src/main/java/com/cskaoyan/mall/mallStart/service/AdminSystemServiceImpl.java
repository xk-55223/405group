package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AdminSystemServiceImpl implements AdminSystemService {
    @Autowired
    AdminSystemMapper adminSystemMapper;

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
}
