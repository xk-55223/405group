package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

import com.cskaoyan.mall.mallStart.bean.Footprint;
import org.apache.ibatis.annotations.Update;

public interface WxPersonalMapper {

    @Select("select order_status from cskaoyan_mall_order ")
    int[] selectOrderStatusId();

    List<Address> selectAddresses(@Param("userId") Integer userId);

    AddressRegion addressDetail(@Param("id") int id);

    String selectProvinceById(@Param("provinceId") int provinceId);

    String selectCityById(@Param("cityId") int cityId);

    String selectAreaById(@Param("areaId") int areaId);

    List<MyCoupon> selectCouponByUserId(@Param("status") Integer status, @Param("userId") Integer userId);

    List<MyCollect> selectCollectsByUserId(@Param("type") Integer type, @Param("userId") Integer userId);

    void updateAddress(@Param("address") AddressRegion addressRegion);


    void addressDelete(@Param("id") int id);

    List<Region> selectRegionByPid(@Param("pid") int pid);

    List<OrderByUser> orderByUserList(@Param("showType") int showType);

    List<OrderGoods> selectOrderGoods(@Param("orderId") int id);

    List<OrderByUser> orderByUserListShowType(@Param("showType") int showType);

    int insertFeedback(@Param("feedback") Feedback feedback);

    void insertAddress(@Param("address") AddressRegion addressRegion, @Param("userId") Integer userId);

    List<Footprint> selectfootprintDetail(@Param("id") Serializable id);

    @Select("select count(id) from cskaoyan_mall_footprint where user_id = #{id}")
    int getTotalNumById(@Param("id") Serializable id);

    @Update("update cskaoyan_mall_order set order_status = 401 where id = #{id}")
    void confirm(int id);
}
