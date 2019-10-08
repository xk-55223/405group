package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.CreateGroupon;
import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.service.wxService.WxPersonalService;
import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.shiro.SecurityUtils;
import com.cskaoyan.mall.mallStart.shiro.CustomToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
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

    @RequestMapping("wx/user/index")
    public BaseRespVo personalIndex() {
        Map order = wxPersonalService.personalIndex();
        return BaseRespVo.ok(order);
    }
   @RequestMapping("wx/groupon/my")
    public BaseRespVo myGroupon(int showType){
       int userId = 1;
       Map<String, Object> objectObjectHashMap = new HashMap<>();
       if(showType == 0){
           objectObjectHashMap =  wxPersonalService.selectCreateGroupons(userId);
            return BaseRespVo.ok(objectObjectHashMap);
       }
       objectObjectHashMap = wxPersonalService.selectJoinedGroupons(userId);
       return BaseRespVo.ok(objectObjectHashMap);
   }



    /*ljq*/
    @RequestMapping("wx/coupon/mylist")
    public BaseRespVo<Map> couponMylist(BrandPageInfo pageInfo, Integer status, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        System.out.println(userId);
        Map resultMap = wxPersonalService.couponMylist(pageInfo, status, userId);
        return BaseRespVo.ok(resultMap);
    }

    @RequestMapping("wx/auth/login")
    public BaseRespVo authLogin(@RequestBody User user) {
        CustomToken wx = new CustomToken(user.getUsername(), user.getPassword(), "wx");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(wx);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        String username = (String) subject.getPrincipal();
        int userId = wxPersonalService.selectUserIdByUserName(username);
        Session session = subject.getSession();
        session.setAttribute("userId", userId);
        Serializable token = session.getId();
        System.out.println(session.getId());
        UserLoginInfo userMessage = wxPersonalService.selectUserMessage(user, token);
        return BaseRespVo.ok(userMessage);
    }

    @RequestMapping("wx/auth/logout")
    public BaseRespVo authLogout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseRespVo.ok(null);
    }

    @RequestMapping("wx/home/index")
    public BaseRespVo homeIndex() {
        Subject subject = SecurityUtils.getSubject();
        WxIndexInfo wxIndexInfo = wxPersonalService.homeIndex();
        return BaseRespVo.ok(wxIndexInfo);
    }

    @RequestMapping("wx/auth/regCaptcha")
    public BaseRespVo regCaptcha(@RequestBody Map map) {

        String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
        System.out.println(code);
        String mobile = (String) map.get("mobile");
        wxPersonalService.sendMessage(mobile, code);
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("code", code);
        Serializable id1 = session.getId();
        System.out.println(id1);
        return BaseRespVo.ok(id1);
    }

    @RequestMapping("wx/auth/register")
    public BaseRespVo register(@RequestBody Map map) {
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session.getId());
        String codeFromSession = (String) session.getAttribute("code");
        String code = (String) map.get("code");
        if (!code.equals(codeFromSession)) {
            return BaseRespVo.fail("验证码错误");
        }

        return BaseRespVo.ok(null);
    }


    //-----------------地址管理------------------------
    @RequestMapping("wx/address/list")
    public BaseRespVo addressList() {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        List<Address> addresses = wxPersonalService.addressList(userId);
        BaseRespVo ok = BaseRespVo.ok(addresses);
        return ok;
    }

    @RequestMapping("wx/address/detail")
    public BaseRespVo addressDetail(int id) {
        AddressRegion addressRegion = wxPersonalService.addressDetail(id);
        BaseRespVo ok = BaseRespVo.ok(addressRegion);
        return ok;
    }

    @RequestMapping("wx/address/save")
    public BaseRespVo addressSave(@RequestBody AddressRegion addressRegion) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        wxPersonalService.addressSave(addressRegion, userId);
        BaseRespVo ok = BaseRespVo.ok(addressRegion.getId());
        return ok;
    }

    @RequestMapping("wx/address/delete")
    public BaseRespVo addressDelete(@RequestBody Map<String, Integer> map) {
        Integer id = map.get("id");
        wxPersonalService.addressDelete(id);
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }

    @RequestMapping("wx/region/list")
    public BaseRespVo regionList(int pid) {
        List<Region> regions = wxPersonalService.selectRegionByPid(pid);
        BaseRespVo ok = BaseRespVo.ok(regions);
        return ok;
    }

    //--------------------订单--------------
    @RequestMapping("wx/order/list")
    public BaseRespVo orderList(short showType, int page, int size) {
       OrderByUserBean orderByUserBean = wxPersonalService.orderList(showType,page,size);
        BaseRespVo ok = BaseRespVo.ok(orderByUserBean);
        return ok;
    }
}
