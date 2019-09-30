package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.Region;

import java.util.List;

public interface AdminMallMapper {

    List<Region> selectRegions();

    List<Region> selectCitysByPid(int pid) ;

    List<Region> selectTownsByCode(int code) ;
}
