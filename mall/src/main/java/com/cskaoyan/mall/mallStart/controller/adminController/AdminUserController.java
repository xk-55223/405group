package com.cskaoyan.mall.mallStart.controller.adminController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminUserService;
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
        return BaseRespVo.ok(userListBean);
    }

    /*收货地址*/
    @RequestMapping("admin/address/list")
    public BaseRespVo<List<User>> addressList(FromPageInfo pageInfo, String name, Integer userId) {
        ListBean<AddressRegion> addressRegionListBean = adminUserService.selectAddressAll(pageInfo, name, userId);
        return BaseRespVo.ok(addressRegionListBean);
    }

    /*会员收藏*/
    @RequestMapping("admin/collect/list")
    public BaseRespVo<List<Collect>> collectList(FromPageInfo pageInfo, Integer userId, Integer valueId) {
        ListBean<Collect> collectListBean = adminUserService.selectCollectAll(pageInfo, userId, valueId);
        return BaseRespVo.ok(collectListBean);
    }

    /*会员足迹*/
    @RequestMapping("admin/footprint/list")
    public BaseRespVo<List<Footprint>> footprintList(FromPageInfo pageInfo, Integer userId, Integer goodsId) {
        ListBean<Footprint> footprintListBean = adminUserService.selectFootprintAll(pageInfo, userId, goodsId);
        return BaseRespVo.ok(footprintListBean);
    }

    /*搜索历史*/
    @RequestMapping("admin/history/list")
    public BaseRespVo<List<SearchHistory>> historyList(FromPageInfo pageInfo, Integer userId, String keyword) {
        ListBean<SearchHistory> searchHistoryListBean = adminUserService.selectSearchHistoryAll(pageInfo, userId, keyword);
        return BaseRespVo.ok(searchHistoryListBean);
    }

    /*意见反馈*/
    @RequestMapping("admin/feedback/list")
    public BaseRespVo<List<Feedback>> feedbackList(FromPageInfo pageInfo, Integer id, String username) {
        ListBean<Feedback> feedbackListBean = adminUserService.selectFeedbackAll(pageInfo, id, username);
        return BaseRespVo.ok(feedbackListBean);
    }
}
