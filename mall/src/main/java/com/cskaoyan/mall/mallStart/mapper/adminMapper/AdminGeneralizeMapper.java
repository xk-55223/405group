package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface AdminGeneralizeMapper {
    List<Ad> getAllAds(String name, String content);

    /*int insertAdImg();
    Storage queryAdimgById(int id);*/

    int insertAd(Ad ad);

    Ad queryAdById(int id);

    void updateAd(Ad ad);

    @Delete("delete from cskaoyan_mall_ad where id = #{id}")
    void deleteAd(Ad ad);

    List<Coupon> getAllCoupons(@Param("type") Integer type, @Param("status") Integer status, @Param("name") String name);


    void addCoupon(Coupon coupon);

    Coupon queryCoupon(Coupon coupon);

    List<CouponUser> getAllCouponUser(int couponId, Integer userId, Integer status);

    Coupon queryCouponById(int id);

    @Delete("delete from cskaoyan_mall_coupon where id = #{id}")
    void deleteCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    List<Topic> getAllTopic(@Param("title") String title, @Param("subtitle") String subtitle);

    @Delete("delete from cskaoyan_mall_topic where id = #{id}")
    void deleteTopic();


    void addTopic(Topic topic);

    Topic queryTopicById(Integer id);

    void updateTopic(Topic topic);

    List<GrouponRules> getAllGrouponRules(Integer goodsId);

    Goods queryGoodsById(Integer goodsId);

    void insertGrouponRules(GrouponRules grouponRules);

    GrouponRules getGrouponRulesById(Integer id);

    List<GrouponRules> getGrouponRulesByGoodsId(Integer goodId);

    void updateGrouponRules(GrouponRules grouponRules);

    void deleteGrouponRules(Integer id);

    List<Groupon> queryAllGroupons();

    List<GrouponInfo> getGrouponInfo();

    void insertUserCoupon(@Param("userId") Integer userId, @Param("couponId") Integer couponId
            , @Param("nowTime") Date date);


    Integer queryCouponIdByCode(@Param("code") String code);

    int selectUserCouponIsOwn(@Param("userId") Integer userId, @Param("couponId") Integer couponId);

    @Select("select count(rules_id) from cskaoyan_mall_groupon " +
            "where creator_user_id = #{userId}")
    int countGrouponByCreatorId(int userId);

    @Select(" select id,order_id as orderId,groupon_id as grouponId,rules_id as rulesId," +
            "        user_id as userId,creator_user_id as creatorUserId,add_time as addTime,share_url as shareUrl," +
            "        update_time as updateTime,payed,deleted from cskaoyan_mall_groupon where creator_user_id = #{userId} and user_id = #{userId}")
    List<Groupon> queryAllGrouponsByCreator(int userId);

    @Select("select count(id) from cskaoyan_mall_groupon where rules_id = #{rulesId}")
    int selectUsersByGrouponRulesId(Integer rulesId);

    @Select(" select id,order_id as orderId,groupon_id as grouponId,rules_id as rulesId," +
            "        user_id as userId,creator_user_id as creatorUserId,add_time as addTime,share_url as shareUrl," +
            "        update_time as updateTime,payed,deleted from cskaoyan_mall_groupon where user_id = #{userId}")
    List<Groupon> queryAllGrouponsByUserId(int userId);

    @Select("select count(id) from cskaoyan_mall_groupon where user_id = #{userId}")
    int countGrouponByUserId(int userId);

    @Select(" select id,order_id as orderId,groupon_id as grouponId,rules_id as rulesId," +
            "        user_id as userId,creator_user_id as creatorUserId,add_time as addTime,share_url as shareUrl," +
            "        update_time as updateTime,payed,deleted from cskaoyan_mall_groupon where id = #{id}")
    Groupon getGrouponById(int id);

    @Select("select user_Id from cskaoyan_mall_groupon where rules_id = #{rules_id}")
    int[] getUserIdByRulesId(Integer rulesId);
}
