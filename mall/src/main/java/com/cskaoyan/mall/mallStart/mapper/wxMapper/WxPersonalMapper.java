package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Footprint;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;

public interface WxPersonalMapper {
    @Select("select order_status from cskaoyan_mall_order ")
    int[] selectOrderStatusId();

    List<Address> selectAddresses();

    AddressRegion addressDetail(@Param("id") int id);

    String selectProvinceById(@Param("provinceId") int provinceId);

    String selectCityById(@Param("cityId") int cityId);

    String selectAreaById(@Param("areaId") int areaId);

    List<Footprint> selectfootprintDetail(@Param("id")Serializable id);

    @Select("select count(id) from cskaoyan_mall_footprint where user_id = #{id}")
    int getTotalNumById(@Param("id")Serializable id);
}
