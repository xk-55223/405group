package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
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
        return new BeansManager<User>().toListBean(users);
    }

    @Override
    public ListBean<AddressRegion> selectAddressAll(FromPageInfo pageInfo, String name, Integer userId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<AddressRegion> addressRegions = adminUserMapper.selectAddressAll(pageInfo, name, userId);
        return new BeansManager<AddressRegion>().toListBean(addressRegions);
    }

    @Override
    public ListBean<Collect> selectCollectAll(FromPageInfo pageInfo, Integer userId, Integer valueId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Collect> collects = adminUserMapper.selectCollectAll(pageInfo, userId, valueId);
        return new BeansManager<Collect>().toListBean(collects);
    }

    @Override
    public ListBean<Footprint> selectFootprintAll(FromPageInfo pageInfo, Integer userId, Integer goodsId) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Footprint> footprints = adminUserMapper.selectFootprintAll(pageInfo, userId, goodsId);
        return new BeansManager<Footprint>().toListBean(footprints);
    }

    @Override
    public ListBean<SearchHistory> selectSearchHistoryAll(FromPageInfo pageInfo, Integer userId, String keyword) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<SearchHistory> searchHistories = adminUserMapper.selectSearchHistoryAll(pageInfo, userId, keyword);
        return new BeansManager<SearchHistory>().toListBean(searchHistories);
    }

    @Override
    public ListBean<Feedback> selectFeedbackAll(FromPageInfo pageInfo, Integer id, String username) {
        /*将page,limit,order,sort四个参数封装在FromPageInfo中*/
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getLimit());
        List<Feedback> feedbacks = adminUserMapper.selectFeedbackAll(pageInfo, id, username);
        return new BeansManager<Feedback>().toListBean(feedbacks);
    }
}
