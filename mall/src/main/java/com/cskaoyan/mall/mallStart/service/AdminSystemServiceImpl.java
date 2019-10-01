package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
import com.cskaoyan.mall.mallStart.tool.StringToArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminSystemServiceImpl implements AdminSystemService {
    @Autowired
    AdminSystemMapper adminSystemMapper;

    @Override
    public ListBean<Admin> selectAdminAll(FromPageInfo pageInfo, String username) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<AdminTemp> adminTemps = adminSystemMapper.selectAdminAll(pageInfo, username);
        /*------------------------------------------------------------------------------*/
        List<Admin> admins = new ArrayList<>();
        for (AdminTemp adminTemp : adminTemps) {
            Admin admin = new Admin();
            admin.setId(adminTemp.getId());
            admin.setUsername(adminTemp.getUsername());
            admin.setAvatar(adminTemp.getAvatar());
            admin.setRoleIds(StringToArray.stringToIntArray(adminTemp.getRoleIds()));
            admins.add(admin);
        }
        /*------------------------------------------------------------------------------*/
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
}
