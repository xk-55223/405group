package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
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
    public BaseRespVo<List<User>> userList(PageInfo pageInfo, String username, String mobile) {
        ListBean<User> userListBean = adminUserService.selectUserAll(pageInfo, username, mobile);
        BaseRespVo ok = BaseRespVo.ok(userListBean);
        return ok;
    }

    @RequestMapping("admin/address/list")
    public BaseRespVo<List<User>> addressList(PageInfo pageInfo, String name, String stringUserId) {
        int userId;
        /*userId如果没给是null，不能直接用int接收*/
        if (stringUserId == null) {
            userId = 0;
        } else {
            userId = Integer.valueOf(stringUserId);
        }
        ListBean<AddressRegion> addressRegionListBean = adminUserService.selectAddressAll(pageInfo, name, userId);
        BaseRespVo ok = BaseRespVo.ok(addressRegionListBean);
        return ok;
    }
}
