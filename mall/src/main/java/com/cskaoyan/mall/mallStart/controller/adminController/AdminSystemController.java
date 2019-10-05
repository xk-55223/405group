package com.cskaoyan.mall.mallStart.controller.adminController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminSystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class AdminSystemController {
    @Autowired
    AdminSystemService adminSystemService;

    /*用户管理*/
    @RequestMapping("admin/admin/list")
    @RequiresPermissions("admin:admin:list")
    public BaseRespVo<ListBean<Admin>> adminList(FromPageInfo pageInfo, String username) {
        ListBean<Admin> adminListBean = adminSystemService.selectAdminAll(pageInfo, username);
        return BaseRespVo.ok(adminListBean);
    }

    @RequestMapping("admin/role/options")
    public BaseRespVo<List<RoleOptions>> adminList() {
        List<RoleOptions> roleOptions = adminSystemService.selectRoleOptionsAll();
        return BaseRespVo.ok(roleOptions);
    }

    @RequestMapping("admin/log/list")
    @RequiresPermissions("admin:log:list")
    public BaseRespVo<ListBean<Log>> logList(FromPageInfo pageInfo, String name) {
        ListBean<Log> logListBean = adminSystemService.selectLogAll(pageInfo, name);
        return BaseRespVo.ok(logListBean);
    }

    @RequestMapping("admin/role/list")
    @RequiresPermissions("admin:role:list")
    public BaseRespVo<ListBean<Role>> roleList(FromPageInfo pageInfo, String name) {
        ListBean<Role> roleListBean = adminSystemService.selectRoleAll(pageInfo, name);
        return BaseRespVo.ok(roleListBean);
    }

    @RequestMapping(value = "admin/role/create", method = RequestMethod.POST)
    @RequiresPermissions("admin:role:create")
    public BaseRespVo<Role> roleCreate(@RequestBody Role paramRole) {
        Role role = adminSystemService.insertRole(paramRole);
        return BaseRespVo.ok(role);
    }

    @RequestMapping(value = "admin/role/delete", method = RequestMethod.POST)
    @RequiresPermissions("admin:role:delete")
    public Map roleDelete(@RequestBody Role paramRole) {
        adminSystemService.deleteRole(paramRole);
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("errmsg", "成功");
        return responseMap;
    }

    @RequestMapping(value = "admin/role/update", method = RequestMethod.POST)
    @RequiresPermissions("admin:role:update")
    public Map roleUpdate(@RequestBody Role paramRole) {
        adminSystemService.updateRole(paramRole);
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("errmsg", "成功");
        return responseMap;
    }

    @RequestMapping("admin/storage/list")
    @RequiresPermissions("admin:storage:list")
    public BaseRespVo<ListBean<Storage>> storageList(FromPageInfo pageInfo, String key, String name) {
        ListBean<Storage> storageListBean = adminSystemService.selectStorageAll(pageInfo, key, name);
        return BaseRespVo.ok(storageListBean);
    }

    @RequestMapping("admin/storage/create")
    @RequiresPermissions("admin:storage:create")
    public BaseRespVo<Storage> storageCreate(MultipartFile file) throws IOException {
        Storage storage = adminSystemService.insertStorage(file);
        return BaseRespVo.ok(storage);
    }

    @RequestMapping(value = "admin/storage/update", method = RequestMethod.POST)
    @RequiresPermissions("admin:storage:update")
    public BaseRespVo<Storage> storageUpdate(@RequestBody Storage paramStorage) {
        Storage storage = adminSystemService.updateStorage(paramStorage);
        return BaseRespVo.ok(storage);
    }

    @RequestMapping(value = "admin/storage/delete", method = RequestMethod.POST)
    @RequiresPermissions("admin:storage:delete")
    public Map storageDelete(@RequestBody Storage paramStorage) {
        adminSystemService.deleteStorage(paramStorage);
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("errmsg", "成功");
        return responseMap;
    }

    @RequestMapping(value = "admin/admin/create", method = RequestMethod.POST)
    @RequiresPermissions("admin:admin:create")
    public BaseRespVo<Admin> adminCreate(@RequestBody Admin paramAdmin) {
        Admin admin = adminSystemService.insertAdmin(paramAdmin);
        return BaseRespVo.ok(admin);
    }

    @RequestMapping(value = "admin/admin/update", method = RequestMethod.POST)
    @RequiresPermissions("admin:admin:update")
    public BaseRespVo<Admin> adminUpdate(@RequestBody Admin paramAdmin) {
        Admin admin = adminSystemService.updateAdmin(paramAdmin);
        return BaseRespVo.ok(admin);
    }

    @RequestMapping(value = "admin/admin/delete", method = RequestMethod.POST)
    @RequiresPermissions("admin:admin:delete")
    public Map adminDelete(@RequestBody Admin paramAdmin) {
        adminSystemService.deleteAdmin(paramAdmin);
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("errmsg", "成功");
        return responseMap;
    }

    @RequestMapping(value = "admin/role/permissions",method = RequestMethod.GET)
    @RequiresPermissions("admin:role:permission:get")
    public BaseRespVo<Map> rolePermissions(int roleId) {
        int[] roleIds = {roleId};
        List<String> perms = adminSystemService.selectPermsByRolesIds(roleIds);
        List<SystemPermissions> systemPermissions = adminSystemService.selectSystemPermissionsAll();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("assignedPermissions", perms);
        resultMap.put("systemPermissions", systemPermissions);
        return BaseRespVo.ok(resultMap);
    }
    @RequestMapping(value = "admin/role/permissions",method = RequestMethod.POST)
    @RequiresPermissions("admin:role:permission:update")
    public Map changeRolePermissions(@RequestBody RoleIdAndPermissions roleIdAndPermissions) {
        adminSystemService.updatePermissions(roleIdAndPermissions);
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("errno", 0);
        responseMap.put("errmsg", "成功");
        return responseMap;
    }
}
