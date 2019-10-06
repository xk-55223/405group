package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.Brand;
import com.cskaoyan.mall.mallStart.bean.FromPageInfo;
import com.cskaoyan.mall.mallStart.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxBrandMapper {
    List<Brand> selectBrandAll();

    Brand selectBrandById(@Param("id") int id);

    List<Goods> selectGoodsByBrandId(@Param("brandId") int brandId);
}
