package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import com.cskaoyan.mall.mallStart.service.wxService.WxPersonalService;
import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.shiro.SecurityUtils;
import com.cskaoyan.mall.mallStart.shiro.CustomToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
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
    @Autowired
    WxHomeService wxHomeService;


    @RequestMapping("wx/user/index")
    public BaseRespVo personalIndex() {
        Session session = SecurityUtils.getSubject().getSession();
        int id = (int) session.getAttribute("userId");
        Map order = wxPersonalService.personalIndex(id);
        return BaseRespVo.ok(order);
    }

    @RequestMapping("wx/groupon/my")
    public BaseRespVo myGroupon(int showType) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        Map<String, Object> objectObjectHashMap;
        if (showType == 0) {
            objectObjectHashMap = wxPersonalService.selectCreateGroupons(userId);
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


    /*ljq*/
    @RequestMapping("wx/collect/list")
    public BaseRespVo<Map> collectList(BrandPageInfo pageInfo, Integer type, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Map resultMap = wxPersonalService.collectList(pageInfo, type, userId);
        return BaseRespVo.ok(resultMap);
    }

    /*ljq*/
    @RequestMapping("wx/coupon/exchange")
    public BaseRespVo couponExchange(@RequestBody Map paramCode) {
        Integer couponId = wxHomeService.couponExchange((String) paramCode.get("code"));
        System.out.println(couponId);
        if (couponId == null) {
            BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
            baseRespVo.setErrno(742);
            baseRespVo.setData(null);
            baseRespVo.setErrmsg("优惠券不正确");
            return baseRespVo;
        } else {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
            String receiveMessage = wxHomeService.couponReceive(userId, couponId);
            if (receiveMessage == null) {
                return BaseRespVo.ok(null);
            } else {
                return BaseRespVo.fail(receiveMessage);
            }
        }
    }

    /*ljq*/
    @RequestMapping("wx/feedback/submit")
    public BaseRespVo feedbackSubmit(@RequestBody Feedback feedback) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        Integer userId = (Integer) session.getAttribute("userId");
        feedback.setUserId(userId);
        feedback.setUsername(username);
        feedback.setStatus(0);
        feedback.setAddTime(new Date());
        feedback.setUpdateTime(new Date());
        wxPersonalService.feedbackSubmit(feedback);
        return BaseRespVo.ok(null);
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
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Serializable token = session.getId();
        String codeFromSession = (String) session.getAttribute("code");
        String code = (String) map.get("code");
        if (!code.equals(codeFromSession)) {
            return BaseRespVo.fail("验证码错误");
        }
        String mobile = (String) map.get("mobile");
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        boolean register = wxPersonalService.register(mobile, username, password);
        if (register) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setToken(token);
            WxUser userInfo = new WxUser();
            userInfo.setAvatarUrl("");
            userInfo.setNickName(username);
            userLoginInfo.setUserInfo(userInfo);
            Integer userId = wxPersonalService.selectUserIdByUserName(username);
            session.setAttribute("userId",userId);
            return BaseRespVo.ok(userLoginInfo);
        }
        return BaseRespVo.fail("该用户名已存在");
    }

    @RequestMapping("wx/auth/bindPhone")
    public BaseRespVo authBindPhone(@RequestBody Map map) {
        return BaseRespVo.fail("系统内部错误");
    }


    @RequestMapping("wx/auth/reset")
    public BaseRespVo authReset(@RequestBody Map map) {
        String code = (String) map.get("code");
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session.getId());
        String messageCode = (String) session.getAttribute("code");
        if (code != null && code.equals(messageCode)) {
            String mobile = (String) map.get("mobile");
            String password = (String) map.get("password");
            wxPersonalService.resetUser(mobile,password);
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail("验证码错误");
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
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        OrderByUserBean orderByUserBean = wxPersonalService.orderList(showType,page,size,userId);
        BaseRespVo ok = BaseRespVo.ok(orderByUserBean);
        return ok;
    }

    @RequestMapping("wx/groupon/detail")
    public BaseRespVo grouponDetail(int grouponId) {
        GrouponDetail detail = wxPersonalService.grouponDetail(grouponId);
        return BaseRespVo.ok(detail);
    }

    //---------------足迹-----------------
    @RequestMapping("wx/footprint/list")
    public BaseRespVo footprintList(int page, int size) {
        Session session = SecurityUtils.getSubject().getSession();
        int id = (int) session.getAttribute("userId");
        Map footprintList = wxPersonalService.footprintList(page, size, id);
        BaseRespVo ok = BaseRespVo.ok(footprintList);
        return ok;
    }

    @RequestMapping("wx/order/detail")
    public BaseRespVo orderDetail(int orderId) {
        Map<String, Object> detail = new HashMap<>();
        detail = wxPersonalService.orderDetail(orderId);
        return BaseRespVo.ok(detail);
    }
    //---------------订单-------------------
    @RequestMapping("wx/order/cancel")
    public BaseRespVo orderCancel(@RequestBody Map map){
        int id =(int) map.get("orderId");
        wxPersonalService.orderCancel(id);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

    @PostMapping("wx/order/delete")
    public BaseRespVo orderDelete(@RequestBody Map map){
        int id =(int) map.get("orderId");
        wxPersonalService.rmOrder(id);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

    @PostMapping("wx/order/refund")
    public BaseRespVo orderRefund(@RequestBody Map map){
        int id =(int) map.get("orderId");
        wxPersonalService.rmOrder(id);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

    @RequestMapping("wx/order/confirm")
    public BaseRespVo confirm(@RequestBody Map map){
        int id =(int) map.get("orderId");
        wxPersonalService.confirm(id);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}




