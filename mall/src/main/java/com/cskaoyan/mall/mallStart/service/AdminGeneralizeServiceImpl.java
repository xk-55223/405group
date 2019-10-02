package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminGeneralizeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminGeneralizeServiceImpl implements AdminGeneralizeService {
    @Autowired
    AdminGeneralizeMapper mapper;

    @Override
    public AdListBean getAllAds(int page, int limit,String name,String content) {
        PageHelper.startPage(page,limit);
        List<Ad> allAds = mapper.getAllAds(name,content);
        PageInfo<Ad> adPageInfo = new PageInfo<>(allAds);
        long total = adPageInfo.getTotal();
        AdListBean adListBean = new AdListBean();
        adListBean.setItems(allAds);
        adListBean.setTotal(total);
        return adListBean;
    }

    @Override
    public Ad insertAd(Ad ad) {
        int i = mapper.insertAd(ad);
        Ad ad1 = mapper.queryAdById(i);
        return ad1;
    }

    @Override
    public Ad updateAd(Ad ad) {
        Integer id = ad.getId();
        mapper.updateAd(ad);
        Ad ad1 = mapper.queryAdById(id);
        return ad1;
    }

    @Override
    public void deleteAd(Ad ad) {
        mapper.deleteAd(ad);
    }

    @Override
    public CouponBeanList listCoupon(int page, int limit, Integer type, Integer status, String name) {
        PageHelper.startPage(page,limit);
        List<Coupon> coupons = mapper.getAllCoupons(type,status,name);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        CouponBeanList list = new CouponBeanList();
        list.setItems(coupons);
        list.setTotal(total);
        return list;
    }

    @Override
    public Coupon addCoupon(Coupon coupon) {
        mapper.addCoupon(coupon);
        Coupon coupon1 = mapper.queryCoupon(coupon);
        return coupon1;
    }

    @Override
    public CouponUserBeanList listCouponUser(int page, int limit, int couponId, Integer userId, Integer status) {
        PageHelper.startPage(page,limit);
        List<CouponUser> users = mapper.getAllCouponUser(couponId,userId,status);
        PageInfo<CouponUser> couponUserPageInfo = new PageInfo<>(users);
        long total = couponUserPageInfo.getTotal();
        CouponUserBeanList list = new CouponUserBeanList();
        list.setItems(users);
        list.setTotal(total);
        return list;
    }

    @Override
    public Coupon queryCouponById(int id) {
       Coupon coupon = mapper.queryCouponById(id);
       return coupon;
    }

    @Override
    public void deleteCoupon(Coupon coupon) {
        mapper.deleteCoupon(coupon);
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        mapper.updateCoupon(coupon);
        Coupon coupon1 = mapper.queryCoupon(coupon);
        return coupon1;
    }

    @Override
    public GeneralizeTopicBeanList getAllTopic(int page, int limit, String title, String subtitle) {
        PageHelper.startPage(page,limit);
        List<Topic> topics = mapper.getAllTopic(title,subtitle);
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        long total = topicPageInfo.getTotal();
        GeneralizeTopicBeanList list = new GeneralizeTopicBeanList();
        list.setItems(topics);
        list.setTotal(total);
        return list;
    }

    @Override
    public void deleteTopic(Topic topic) {
        mapper.deleteTopic();
    }

    @Override
    public Topic insertTopic(Topic topic) {
        mapper.addTopic(topic);
        Topic topic1 =  mapper.queryTopicById(topic.getId());
        return topic1;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        mapper.updateTopic(topic);
        Topic topic1 = mapper.queryTopicById(topic.getId());
        return topic1;
    }

    @Override
    public ListBean getAllGrouponRules(int page, int limit, Integer goodsId) {
        PageHelper.startPage(page,limit);
        List<GrouponRules> rules = mapper.getAllGrouponRules(goodsId);
        PageInfo<GrouponRules> info = new PageInfo<>(rules);
        long total = info.getTotal();
        ListBean<GrouponRules> objectListBean = new ListBean<>();
        objectListBean.setItems(rules);
        objectListBean.setTotal(total);
        return objectListBean;
    }

    @Override
    public GrouponRules insertGrouponRules(GrouponRules grouponRules) {
        Goods goods =  mapper.queryGoodsById(grouponRules.getGoodsId());
        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());
        mapper.insertGrouponRules(grouponRules);
        GrouponRules rules = mapper.getGrouponRulesById(grouponRules.getId());
        return rules;
    }

    @Override
    public void updateGrouponRules(GrouponRules grouponRules) {
        Goods goods = mapper.queryGoodsById(grouponRules.getGoodsId());
        grouponRules.setPicUrl(goods.getPicUrl());
        grouponRules.setGoodsName(goods.getName());
        mapper.updateGrouponRules(grouponRules);
    }

    @Override
    public void deleteGrouponRules(Integer id) {
        mapper.deleteGrouponRules(id);
    }


}

