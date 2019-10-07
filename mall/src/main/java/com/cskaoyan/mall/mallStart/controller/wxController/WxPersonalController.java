package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.cskaoyan.mall.mallStart.service.wxService.WxPersonalService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: mall
 * @description: 小程序端个人界面
 * @author: silphon
 * * @create: 2019-10-06 17:28
 **/
@RestController
public class WxPersonalController {
    @Autowired
    WxPersonalService wxPersonalService;

   /* @RequestMapping("wx/user/index")
    public BaseRespVo personalIndex() {
        Map order = wxPersonalService.personalIndex();
        return BaseRespVo.ok(order);
    }*/

    /*ljq*/
    @RequestMapping("wx/coupon/mylist")
    public BaseRespVo<Map> couponMylist(BrandPageInfo pageInfo, Integer status, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        System.out.println(userId);
        Map resultMap = wxPersonalService.couponMylist(pageInfo,status,userId);
        return BaseRespVo.ok(resultMap);
    }
}
