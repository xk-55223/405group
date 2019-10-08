package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username, @Param("mobile") String mobile);

    List<AddressRegion> selectAddressAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name, @Param("userId") Integer userId);

    List<Collect> selectCollectAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("valueId") Integer valueId);

    List<Footprint> selectFootprintAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    List<SearchHistory> selectSearchHistoryAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("keyword") String keyword);

    List<Feedback> selectFeedbackAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("id") Integer id, @Param("username") String username);

    @Select("select password from cskaoyan_mall_user where username = #{username}")
    String selectPasswordByUserName(String primaryPrincipal);

    @Select("select avatar as avatarUrl , nickname as nickName from cskaoyan_mall_user where username = #{user.username} and password = #{user.password}")
    WxUser selectUserInfoByUserNameAndPassword(@Param("user") User user);

    int queryCollectType(int userId,int goodsId);

    @Select("select count(id) from cskaoyan_mall_cart where user_id = #{userId}")
    int countCartGoods(int userId);

    @Select("select id from cskaoyan_mall_user where username = #{username}")
    int selectUserIdByUserName(String username);

    @Select("select count(id) from cskaoyan_mall_collect where value_id =" +
            "#{param1} and type = #{param2} and user_id = #{param3}")
    int isGoodsCollected(int valueId, int type, int userId);

    @Insert("insert into cskaoyan_mall_collect values(0,#{param3},#{param1},#{param2},now(),now(),0)")
    void collectGoods(int valueId, int type, int userId);

    @Delete("delete from cskaoyan_mall_collect where value_id ="  +
            "#{param1} and type = #{param2} and user_id = #{param3}")
    void deleteCollectGoods(int valueId, int type, int userId);

    void insertGoodsToCart(Cart cart);

    @Select("select count(id) from cskaoyan_mall_cart where user_id = #{userId}")
    int countCartGoodsByUserId(int userId);

    int insertUser(@Param("user") User user);

    @Update("update cskaoyan_mall_user set password = #{password} where mobile = #{mobile}")
    void updateUserPasswordByMoblie(@Param("mobile") String mobile, @Param("password") String password);

    @Select("select nickname from cskaoyan_mall_user where id = #{userId}")
    String getUserNicknameById(int userId);

    @Select("select creator_user_id from cskaoyan_mall_groupon where user_id = #{param1} and rules_id = #{param2}")
    int getOrderCreatorByUserId(int userId, Integer rulesId);

    @Select("select creator_user_id from cskaoyan_mall_groupon where id = #{id}")
    int getOrderCreatorById(int id);

    // 仅用于订单下单使用
    @Select("select nickname, mobile from cskaoyan_mall_user where id = #{userId}")
    User selectUserInfoByUserId(Integer userId);
    @Select("insert into cskaoyan_mall_footprint values(0,#{param2},#{param1},now(),now(),0)")
    void insertFootprint(int id, int userId);

    @Select("select avatar from cskaoyan_mall_user where id = #{userId}")
    String getUserAvatarById(int userId);

    @Delete("delete from cskaoyan_mall_footprint where user_id = #{param2} and goods_id = #{param1}")
    void deleteFootPrint(int id, int userId);

}
