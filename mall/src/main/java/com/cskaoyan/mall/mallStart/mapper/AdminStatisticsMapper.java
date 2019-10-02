package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminStatisticsMapper {
    double selectSumOrderPriceByPaytime(@Param("date") Date date);

    int selectSumUserByPaytime(@Param("date")Date date);

    int selectSumOrderByPaytime(@Param("date")Date date);
    //查找用户根据时间去重
    List<User> selectUserAllGroupByAddTime();

    int selectSumUserByAddTime(@Param("date") Date addTime);
}
