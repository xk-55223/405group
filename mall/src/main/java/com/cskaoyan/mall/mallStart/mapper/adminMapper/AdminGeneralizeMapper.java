package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminGeneralizeMapper {
    List<Ad> getAllAds(String name,String content);

    /*int insertAdImg();
    Storage queryAdimgById(int id);*/

    int insertAd(Ad ad);
    Ad queryAdById(int id);

    void updateAd(Ad ad);

    @Delete("delete from cskaoyan_mall_ad where id = #{id}")
    void deleteAd(Ad ad);

    List<Coupon> getAllCoupons(@Param("type")Integer type,@Param("status") Integer status,@Param("name") String name);


    void addCoupon(Coupon coupon);
    Coupon queryCoupon(Coupon coupon);

    List<CouponUser> getAllCouponUser(int couponId, Integer userId, Integer status);

    Coupon queryCouponById(int id);

    @Delete("delete from cskaoyan_mall_coupon where id = #{id}")

    void deleteCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    List<Topic> getAllTopic(@Param("title")String title,@Param("subtitle") String subtitle);

    @Delete("delete from cskaoyan_mall_topic where id = #{id}")
    void deleteTopic();


    void addTopic(Topic topic);

    Topic queryTopicById(Integer id);

    void updateTopic(Topic topic);

    List<GrouponRules> getAllGrouponRules(Integer goodsId);

    Goods queryGoodsById(Integer goodsId);

    void insertGrouponRules( GrouponRules grouponRules);

    GrouponRules getGrouponRulesById(Integer id);

    void updateGrouponRules(GrouponRules grouponRules);

    void deleteGrouponRules(Integer id);

    List<Groupon> queryAllGroupons();
}
