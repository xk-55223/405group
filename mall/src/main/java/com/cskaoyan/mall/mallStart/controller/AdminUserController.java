package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("admin/user/list")
    public BaseRespVo<List<User>> userList(int page, int limit, String add_time, String order) {
        ListBean<User> userListBean = adminUserService.selectUserAll(page, limit, add_time, order);
        BaseRespVo ok = BaseRespVo.ok(userListBean);
        return ok;
    }
}
