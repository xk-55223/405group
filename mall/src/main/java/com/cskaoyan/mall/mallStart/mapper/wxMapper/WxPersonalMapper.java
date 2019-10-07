package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxPersonalMapper {
    @Select("select order_status from cskaoyan_mall_order ")
    int[] selectOrderStatusId();

    List<Address> selectAddresses();

    AddressRegion addressDetail(@Param("id") int id);

    String selectProvinceById(@Param("provinceId") int provinceId);

    String selectCityById(@Param("cityId") int cityId);

    String selectAreaById(@Param("areaId") int areaId);
}
