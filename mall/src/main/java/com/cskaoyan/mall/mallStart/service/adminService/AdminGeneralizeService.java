package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;

public interface AdminGeneralizeService {

    AdListBean getAllAds(int page, int limit, String name, String content);

    Ad insertAd(Ad ad);

    Ad updateAd(Ad ad);

    void deleteAd(Ad ad);

    CouponBeanList listCoupon(int page, int limit, Integer type, Integer status, String name);

    Coupon addCoupon(Coupon coupon);

    CouponUserBeanList listCouponUser(int page, int limit, int couponId, Integer userId, Integer status);

    Coupon queryCouponById(int id);

    void deleteCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);

    GeneralizeTopicBeanList getAllTopic(int page, int limit, String title, String subtitle);

    void deleteTopic(Topic topic);

    Topic insertTopic(Topic topic);

    Topic updateTopic(Topic topic);

    ListBean getAllGrouponRules(int page, int limit, Integer goodsId);

    GrouponRules insertGrouponRules(GrouponRules grouponRules);

    void updateGrouponRules(GrouponRules grouponRules);

    void deleteGrouponRules(Integer id);

    ListBean listGroupon(int page, int limit, Integer goodsId);

    Boolean isGoodsExist(Integer goodsId);
}
