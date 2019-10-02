package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
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
        PageInfo adminPageInfo = new PageInfo(admins);
        long total = adminPageInfo.getTotal();
        ListBean<Admin> adminListBean = new ListBean<>();
        adminListBean.setItems(admins);
        adminListBean.setTotal(total);
        return adminListBean;
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
        PageInfo logPageInfo = new PageInfo(logs);
        long total = logPageInfo.getTotal();
        ListBean<Log> logListBean = new ListBean<>();
        logListBean.setItems(logs);
        logListBean.setTotal(total);
        return logListBean;
    }
}
