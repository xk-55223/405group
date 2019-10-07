package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.MyCoupon;
import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Region;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;
import com.cskaoyan.mall.mallStart.bean.Footprint;

public interface WxPersonalMapper {

    @Select("select order_status from cskaoyan_mall_order ")
    int[] selectOrderStatusId();

    List<Address> selectAddresses(@Param("userId") Integer userId);

    AddressRegion addressDetail(@Param("id") int id);

    String selectProvinceById(@Param("provinceId") int provinceId);

    String selectCityById(@Param("cityId") int cityId);

    String selectAreaById(@Param("areaId") int areaId);


    List<MyCoupon> selectCouponByUserId(@Param("status") Integer status,@Param("userId") Integer userId);

    void updateAddress(@Param("address") AddressRegion addressRegion);
    void addressDelete(@Param("id") int id);

    List<Region> selectRegionByPid(@Param("pid") int pid);

    void insertAddress(@Param("address") AddressRegion addressRegion,@Param("userId") Integer userId);

    List<Footprint> selectfootprintDetail(@Param("id")Serializable id);

    @Select("select count(id) from cskaoyan_mall_footprint where user_id = #{id}")
    int getTotalNumById(@Param("id")Serializable id);

}
