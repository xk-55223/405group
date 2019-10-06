package com.cskaoyan.mall.mallStart.controller.wxController;
import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.GoodsCount;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminSystemService;
import com.cskaoyan.mall.mallStart.service.wxService.WxHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @RequestMapping("wx/home/index")
    public BaseRespVo homeIndex() {
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

    public BaseRespVo goodsList(String keyword, FromPageInfo info, Integer categoryId, Integer brandId) {

        int userId = 1;
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
    public BaseRespVo<Map> commentList(BrandPageInfo pageInfo, int valueId, int type, int showType) {
        Map resultMap = wxHomeService.selectCommentsByValueId(pageInfo, valueId);
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
    public BaseRespVo<Comment> commentPost(@RequestBody Comment comment, HttpServletRequest request) {
        Comment resultComment = wxHomeService.commentPost(comment,request);
        return BaseRespVo.ok(resultComment);
    }

    /*ljq临时login*/
    @RequestMapping("wx/auth/login")
    public BaseRespVo<Map> authLogin() {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        Map<String, String> userInfo = new LinkedHashMap<>();
        userInfo.put("nickName", "wx");
        userInfo.put("avatarUrl", "");
        resultMap.put("userInfo", userInfo);
        resultMap.put("tokenExpire", "2019-10-07T09:30:55.542");
        resultMap.put("token", "mdrbticbuyp59yynqhsf2rre6ihxst7m");
        return BaseRespVo.ok(resultMap);
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
}
