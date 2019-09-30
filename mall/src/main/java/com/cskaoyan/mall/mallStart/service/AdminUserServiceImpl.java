package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.PageInfo;
import com.cskaoyan.mall.mallStart.mapper.AdminUserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public ListBean<User> selectUserAll(PageInfo userInfo,String username,String mobile) {
        PageHelper.startPage(userInfo.getPage(), userInfo.getLimit());
        /*String add_time, String order暂未解决*/
        List<User> users = adminUserMapper.selectUserAll(username,mobile);
        com.github.pagehelper.PageInfo userPageInfo = new com.github.pagehelper.PageInfo(users);
        long total = userPageInfo.getTotal();
        ListBean<User> userListBean = new ListBean<>();
        userListBean.setItems(users);
        userListBean.setTotal((int) total);
        return userListBean;
    }
}
