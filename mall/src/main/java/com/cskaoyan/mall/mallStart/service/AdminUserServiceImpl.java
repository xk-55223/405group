package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public ListBean<User> selectUserAll(FromPageInfo pageInfo, String username, String mobile) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<User> users = adminUserMapper.selectUserAll(pageInfo, username, mobile);
        PageInfo userPageInfo = new PageInfo(users);
        long total = userPageInfo.getTotal();
        ListBean<User> userListBean = new ListBean<>();
        userListBean.setItems(users);
        userListBean.setTotal(total);
        return userListBean;
    }

    @Override
    public ListBean<AddressRegion> selectAddressAll(FromPageInfo pageInfo, String name, Integer userId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<AddressRegion> addressRegions = adminUserMapper.selectAddressAll(pageInfo, name, userId);
        PageInfo addressRegionPageInfo = new PageInfo(addressRegions);
        long total = addressRegionPageInfo.getTotal();
        ListBean<AddressRegion> addressRegionListBean = new ListBean<>();
        addressRegionListBean.setItems(addressRegions);
        addressRegionListBean.setTotal(total);
        return addressRegionListBean;
    }

    @Override
    public ListBean<Collect> selectCollectAll(FromPageInfo pageInfo, Integer userId, Integer valueId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Collect> collects = adminUserMapper.selectCollectAll(pageInfo, userId, valueId);
        PageInfo<Collect> collectPageInfo = new PageInfo<>(collects);
        long total = collectPageInfo.getTotal();
        ListBean<Collect> collectListBean = new ListBean<>();
        collectListBean.setItems(collects);
        collectListBean.setTotal(total);
        return collectListBean;
    }

    @Override
    public ListBean<Footprint> selectFootprintAll(FromPageInfo pageInfo, Integer userId, Integer goodsId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Footprint> footprints = adminUserMapper.selectFootprintAll(pageInfo, userId, goodsId);
        PageInfo<Footprint> footprintPageInfo = new PageInfo<>(footprints);
        long total = footprintPageInfo.getTotal();
        ListBean<Footprint> footprintListBean = new ListBean<>();
        footprintListBean.setItems(footprints);
        footprintListBean.setTotal(total);
        return footprintListBean;
    }

    @Override
    public ListBean<SearchHistory> selectSearchHistoryAll(FromPageInfo pageInfo, Integer userId, String keyword) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<SearchHistory> searchHistories = adminUserMapper.selectSearchHistoryAll(pageInfo, userId, keyword);
        PageInfo<SearchHistory> searchHistoryPageInfo = new PageInfo<>(searchHistories);
        long total = searchHistoryPageInfo.getTotal();
        ListBean<SearchHistory> searchHistoryListBean = new ListBean<>();
        searchHistoryListBean.setItems(searchHistories);
        searchHistoryListBean.setTotal(total);
        return searchHistoryListBean;
    }

    @Override
    public ListBean<Feedback> selectFeedbackAll(FromPageInfo pageInfo, Integer id, String username) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Feedback> feedbacks = adminUserMapper.selectFeedbackAll(pageInfo, id, username);
        PageInfo<Feedback> feedbackPageInfo = new PageInfo<>(feedbacks);
        long total = feedbackPageInfo.getTotal();
        ListBean<Feedback> feedbackListBean = new ListBean<>();
        feedbackListBean.setItems(feedbacks);
        feedbackListBean.setTotal(total);
        return feedbackListBean;
    }
}
