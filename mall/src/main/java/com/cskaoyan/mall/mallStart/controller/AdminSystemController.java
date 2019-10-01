package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.AdminSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminSystemController {
    @Autowired
    AdminSystemService adminSystemService;

    /*用户管理*/
    @RequestMapping("admin/admin/list")
    public BaseRespVo<List<Admin>> adminList(FromPageInfo pageInfo, String username) {
        ListBean<Admin> adminListBean = adminSystemService.selectAdminAll(pageInfo, username);
        BaseRespVo ok = BaseRespVo.ok(adminListBean);
        return ok;
    }

    @RequestMapping("admin/role/options")
    public BaseRespVo<List<RoleOptions>> adminList() {
        List<RoleOptions> roleOptions = adminSystemService.selectRoleOptionsAll();
        BaseRespVo ok = BaseRespVo.ok(roleOptions);
        return ok;
    }
}
