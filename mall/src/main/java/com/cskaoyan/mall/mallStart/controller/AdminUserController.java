package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    /*用户管理*/
    @RequestMapping("admin/user/list")
    public BaseRespVo<List<User>> userList(FromPageInfo pageInfo, String username, String mobile) {
        ListBean<User> userListBean = adminUserService.selectUserAll(pageInfo, username, mobile);
        BaseRespVo ok = BaseRespVo.ok(userListBean);
        return ok;
    }

    /*收货地址*/
    @RequestMapping("admin/address/list")
    public BaseRespVo<List<User>> addressList(FromPageInfo pageInfo, String name, Integer userId) {
        ListBean<AddressRegion> addressRegionListBean = adminUserService.selectAddressAll(pageInfo, name, userId);
        BaseRespVo ok = BaseRespVo.ok(addressRegionListBean);
        return ok;
    }

    /*会员收藏*/
    @RequestMapping("admin/collect/list")
    public BaseRespVo<List<Collect>> collectList(FromPageInfo pageInfo, Integer userId, Integer valueId) {
        ListBean<Collect> collectListBean = adminUserService.selectCollectAll(pageInfo, userId, valueId);
        BaseRespVo ok = BaseRespVo.ok(collectListBean);
        return ok;
    }
    /*会员足迹*/
    @RequestMapping("admin/footprint/list")
    public BaseRespVo<List<Footprint>> footprintList(FromPageInfo pageInfo, Integer userId, Integer goodsId) {
        ListBean<Footprint> footprintListBean = adminUserService.selectFootprintAll(pageInfo, userId, goodsId);
        BaseRespVo ok = BaseRespVo.ok(footprintListBean);
        return ok;
    }
    /*搜索历史*/
    @RequestMapping("admin/history/list")
    public BaseRespVo<List<SearchHistory>> historyList(FromPageInfo pageInfo, Integer userId, String keyword) {
        ListBean<SearchHistory> searchHistoryListBean = adminUserService.selectSearchHistoryAll(pageInfo, userId, keyword);
        BaseRespVo ok = BaseRespVo.ok(searchHistoryListBean);
        return ok;
    }
}
