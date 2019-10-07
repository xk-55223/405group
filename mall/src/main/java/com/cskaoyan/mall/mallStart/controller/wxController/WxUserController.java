package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxUserController {

    @RequestMapping("wx/auth/login")
    public BaseRespVo login(){
        UserInfo userInfo = new UserInfo();
        BaseRespVo ok = BaseRespVo.ok(userInfo);
        return ok;
    }
}
