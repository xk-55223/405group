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
        return BaseRespVo.ok(adminListBean);
    }

    @RequestMapping("admin/role/options")
    public BaseRespVo<List<RoleOptions>> adminList() {
        List<RoleOptions> roleOptions = adminSystemService.selectRoleOptionsAll();
        return BaseRespVo.ok(roleOptions);
    }

    @RequestMapping("admin/log/list")
    public BaseRespVo<List<Log>> logList(FromPageInfo pageInfo, String name) {
        ListBean<Log> logListBean = adminSystemService.selectLogAll(pageInfo, name);
        return BaseRespVo.ok(logListBean);
    }

    @RequestMapping("admin/role/list")
    public BaseRespVo<List<Role>> roleList(FromPageInfo pageInfo, String name) {
        ListBean<Role> roleListBean = adminSystemService.selectRoleAll(pageInfo, name);
        return BaseRespVo.ok(roleListBean);
    }
}
