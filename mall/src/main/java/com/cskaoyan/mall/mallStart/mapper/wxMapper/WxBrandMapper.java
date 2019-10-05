package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.Brand;
import com.cskaoyan.mall.mallStart.bean.FromPageInfo;

import java.util.List;

public interface WxBrandMapper {
    List<Brand> selectBrandAll(FromPageInfo pageInfo);
}
