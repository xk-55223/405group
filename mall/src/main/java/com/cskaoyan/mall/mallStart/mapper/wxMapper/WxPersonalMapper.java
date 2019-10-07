package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.MyCoupon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxPersonalMapper {
    /*  @Select("select order_status from cskaoyan_mall_order ")
      int[] selectOrderStatusId();*/
    List<MyCoupon> selectCouponByUserId(@Param("status") Integer status, @Param("userId") Integer userId);
}
