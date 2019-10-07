package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminUserMapper {
    List<User> selectUserAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("username") String username, @Param("mobile") String mobile);

    List<AddressRegion> selectAddressAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("name") String name, @Param("userId") Integer userId);

    List<Collect> selectCollectAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("valueId") Integer valueId);

    List<Footprint> selectFootprintAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    List<SearchHistory> selectSearchHistoryAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("userId") Integer userId, @Param("keyword") String keyword);

    List<Feedback> selectFeedbackAll(@Param("pageInfo") FromPageInfo pageInfo, @Param("id") Integer id, @Param("username") String username);

    int queryCollectType(int userId,int goodsId);

    @Select("select count(id) from cskaoyan_mall_cart where user_id = #{userId}")
    int countCartGoods(int userId);

    @Select("select count(id) from cskaoyan_mall_collect where value_id =" +
            "#{param1} and type = #{param2} and user_id = #{param3}")
    int isGoodsCollected(int valueId, int type, int userId);

    @Insert("insert into cskaoyan_mall_collect values(0,#{param3},#{param1},#{param2},now(),now(),0)")
    void collectGoods(int valueId, int type, int userId);

    @Delete("delete from cskaoyan_mall_collect where value_id ="  +
            "#{param1} and type = #{param2} and user_id = #{param3}")
    void deleteCollectGoods(int valueId, int type, int userId);

    void insertGoodsToCart(@Param("goods") Goods goods,@Param("product") GoodsProduct product,@Param("number") int number,@Param("userId") int userId);

    @Select("select count(id) from cskaoyan_mall_cart where user_id = #{userId}")
    int countCartGoodsByUserId(int userId);
}
