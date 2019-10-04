package com.cskaoyan.mall.mallStart.controller.adminController;

import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.bean.LoginInfo;
<<<<<<< HEAD:mall/src/main/java/com/cskaoyan/mall/mallStart/controller/adminController/AdminFirstPageController.java
import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.service.adminService.AdminFirstPageServiceImpl;
=======
import com.cskaoyan.mall.mallStart.service.AdminFirstPageServiceImpl;
>>>>>>> 67beb030f74fdadbeca5f3ef180d4d7e11e57555:mall/src/main/java/com/cskaoyan/mall/mallStart/controller/AdminFirstPageController.java
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class AdminFirstPageController {
    @Autowired
    AdminFirstPageServiceImpl firstPageService;

    //首页接口，service主要是从四个表中count(id)获取数量，
    //包装类为DashBoard，四个表为 cskaoyan_mall_user、goods、order、goods_product
    @RequestMapping("admin/dashboard")
    public BaseRespVo dashboard() {
        DashBoard dashBorad = firstPageService.getDashBorad();
        BaseRespVo result = BaseRespVo.ok(dashBorad);
        return result;
    }


    @RequestMapping("admin/auth/login")
    public BaseRespVo login(@RequestBody Admin admin) {
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(), admin.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail("账号或者密码错误");
        }
        Serializable id = subject.getSession().getId();
        return BaseRespVo.ok(id);
    }


    @RequestMapping("admin/auth/info")
    public BaseRespVo info(String token) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        LoginInfo loginInfo = firstPageService.selectLoginInfoByUsername(username);
        return BaseRespVo.ok(loginInfo);
    }

    // 退出登录，失败
    @RequestMapping("admin/auth/logout")
    public BaseRespVo logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok(null);
    }

    // 认证失败
    @RequestMapping("fail")
    public BaseRespVo fail() {
        BaseRespVo fail = BaseRespVo.fail("您无权访问,请先登录");
        return fail;
    }
}
