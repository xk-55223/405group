package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import com.cskaoyan.mall.mallStart.shiro.CustomToken;
import jdk.nashorn.internal.objects.NativeUint16Array;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WxHomeController {
    @Autowired
    WxHomeService wxHomeService;

    @RequestMapping("wx/auth/login")
    public BaseRespVo authLogin(@RequestBody User user) {
        CustomToken wx = new CustomToken(user.getUsername(), user.getPassword(), "wx");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println(session.getId());
        try {
            subject.login(wx);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        UserLoginInfo userMessage = wxHomeService.selectUserMessage(user);
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
        WxIndexInfo wxIndexInfo = wxHomeService.homeIndex();
        return BaseRespVo.ok(wxIndexInfo);
    }

    @RequestMapping("wx/goods/count")
    public BaseRespVo goodsCount() {
        GoodsCount goodsCount = wxHomeService.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }

    // 搜索时显示关键词信息
    @RequestMapping("wx/search/index")
    public BaseRespVo searchIndex() {
        int userId = 1;
        SearchIndexInfo indexInfo = wxHomeService.searchIndex(userId);
        return BaseRespVo.ok(indexInfo);
    }

    @RequestMapping("wx/search/helper")
    public BaseRespVo searchHelper(String keyword) {
        List<String> keywords = wxHomeService.searchHelper(keyword);
        return BaseRespVo.ok(keywords);
    }

    @RequestMapping("wx/goods/list")
    public BaseRespVo goodsList(String keyword, FromPageInfo info,Integer categoryId,Integer brandId) {
        int userId = 1;
        GoodsListInfo goodsListInfo = wxHomeService.goodsList(userId, keyword, info, categoryId,brandId);
        return BaseRespVo.ok(goodsListInfo);
    }
    /*ljq*/
    @RequestMapping("wx/brand/list")
    public BaseRespVo<Map> brandList(BrandPageInfo pageInfo) {
        Map resultMap = wxHomeService.selectBrandAll(pageInfo);
        return BaseRespVo.ok(resultMap);
    }

    /*ljq*/
    @RequestMapping("wx/brand/detail")
    public BaseRespVo<Map> brandDetail(int id) {
        Map resultMap = wxHomeService.selectBrandById(id);
        return BaseRespVo.ok(resultMap);
    }


    /*ljq*/
    @RequestMapping("wx/topic/list")
    public BaseRespVo<Map> topicList(BrandPageInfo pageInfo) {
        Map result = wxHomeService.selectTopicAll(pageInfo);
        return BaseRespVo.ok(result);
    }


    @RequestMapping("wx/search/clearhistory")
    public BaseRespVo searchClearhistory() {
        int id = 1;
        wxHomeService.searchClearhistory(id);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("wx/goods/category")
    public BaseRespVo goodsCategory(Integer id) {
        GoodsCategoryInfo categoryInfo = wxHomeService.goodsCategory(id);
        return BaseRespVo.ok(categoryInfo);
    }

    @RequestMapping("wx/coupon/list")
    public BaseRespVo couponList(FromPageInfo fromPageInfo) {
        CouponListInfo couponListInfo = wxHomeService.couponList(fromPageInfo);
        return BaseRespVo.ok(couponListInfo);
    }

    @RequestMapping("wx/user/index")
    public BaseRespVo userIndex() {
        int userId = 1;
        UserIndexInfo indexInfo = wxHomeService.selectUserIndexInfo(userId);
        return BaseRespVo.ok(indexInfo);
    }

    @RequestMapping("wx/coupon/receive")
    public BaseRespVo couponReceive(@RequestBody Map<String,Integer> map) {
        Integer couponId = map.get("couponId");
        int userId = 1;
        String receiveMessage = wxHomeService.couponReceive(userId,couponId);
        if (receiveMessage == null) {
            return BaseRespVo.ok(null);
        } else {
            return BaseRespVo.fail(receiveMessage);
        }
    }

    @RequestMapping("wx/groupon/list")
    public BaseRespVo grouponList(FromPageInfo fromPageInfo) {
        GrouponPageInfo grouponInfo = wxHomeService.grouponList(fromPageInfo);
        return BaseRespVo.ok(grouponInfo);
    }
}
