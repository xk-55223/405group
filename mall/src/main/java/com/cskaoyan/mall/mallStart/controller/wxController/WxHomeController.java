package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.GoodsCount;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminSystemService;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import com.cskaoyan.mall.mallStart.shiro.CustomToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WxHomeController {
    @Autowired
    WxHomeService wxHomeService;
    @Autowired
    AdminSystemService adminSystemService;


    @RequestMapping("wx/goods/count")
    public BaseRespVo goodsCount() {
        GoodsCount goodsCount = wxHomeService.goodsCount();
        return BaseRespVo.ok(goodsCount);
    }

    // 搜索时显示关键词信息
    @RequestMapping("wx/search/index")
    public BaseRespVo searchIndex() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Serializable id = session.getId();
        System.out.println(id);
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return BaseRespVo.ok(null);
        }
        SearchIndexInfo indexInfo = wxHomeService.searchIndex(userId);
        return BaseRespVo.ok(indexInfo);
    }

    @RequestMapping("wx/search/helper")
    public BaseRespVo searchHelper(String keyword) {
        List<String> keywords = wxHomeService.searchHelper(keyword);
        return BaseRespVo.ok(keywords);
    }

    @RequestMapping("wx/goods/list")

    public BaseRespVo goodsList(String keyword, FromPageInfo info, Integer categoryId, Integer brandId) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        GoodsListInfo goodsListInfo = wxHomeService.goodsList(userId, keyword, info, categoryId, brandId);
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

    /*ljq*/
    @RequestMapping("wx/topic/detail")
    public BaseRespVo<Map> topicDetail(int id) {
        Map result = wxHomeService.selectTopicById(id);
        return BaseRespVo.ok(result);
    }

    /*ljq*/
    @RequestMapping("wx/topic/related")
    public BaseRespVo<List<Topic>> topicRelated(int id) {
        List<Topic> topics = wxHomeService.selectTopicRelated(id);
        return BaseRespVo.ok(topics);
    }

    /*ljq*/
    @RequestMapping("wx/comment/list")
    public BaseRespVo<Map> commentList(BrandPageInfo pageInfo, Integer valueId, Integer type, Integer showType) {
        Map resultMap = wxHomeService.selectCommentsByValueId(pageInfo, valueId, type, showType);
        return BaseRespVo.ok(resultMap);
    }

    /*ljq*/
    @RequestMapping("wx/comment/count")
    public BaseRespVo<Map> commentCount(Integer valueId, Integer type) {
        Map resultMap = wxHomeService.commentCount(valueId, type);
        return BaseRespVo.ok(resultMap);
    }

    /*ljq*/
    @RequestMapping(value = "wx/storage/upload", method = RequestMethod.POST)
    public BaseRespVo<Role> roleCreate(MultipartFile file) throws IOException {
        Storage storage = adminSystemService.insertStorage(file);
        return BaseRespVo.ok(storage);
    }

    /*ljq*/
    @RequestMapping("wx/comment/post")
    public BaseRespVo<Comment> commentPost(@RequestBody Comment comment) {
        Comment resultComment = wxHomeService.commentPost(comment, (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId"));
        return BaseRespVo.ok(resultComment);
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


    @RequestMapping("wx/coupon/receive")
    public BaseRespVo couponReceive(@RequestBody Map<String, Integer> map) {
        Integer couponId = map.get("couponId");
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        int userId = (int) session.getAttribute("userId");
        String receiveMessage = wxHomeService.couponReceive(userId, couponId);
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
