package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    void insertAddress(@Param("address") AddressRegion addressRegion, @Param("userId") Integer userId);

    int insertFeedback(@Param("feedback") Feedback feedback);
}
