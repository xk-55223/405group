package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.mapper.AdminUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public ListBean<User> selectUserAll(int page, int limit, String add_time, String order) {
        PageHelper.startPage(page, limit);
        /*String add_time, String order暂未解决*/
        List<User> users = adminUserMapper.selectUserAll(add_time,order);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        ListBean<User> userListBean = new ListBean<>();
        userListBean.setItems(users);
        userListBean.setTotal((int) total);
        return userListBean;
    }
}
