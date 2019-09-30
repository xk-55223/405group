package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Brand;
import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.CategoryType;
import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.mapper.AdminMallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMallServiceImpl implements AdminMallService {
    @Autowired
    AdminMallMapper mapper;

    @Override
    public List<Region> selectRegions() {
        List<Region> regions = mapper.selectRegions();
        System.out.println(regions);
        return regions;
    }

    @Override
    public List<Brand> selectBrands() {
        return mapper.selectBrands();
    }

    @Override
    public List<Category> selectCategorys() {
        return mapper.selectCategorys();
    }

    @Override
    public List<CategoryType> selectCategoryTypes() {
        return mapper.selectCategoryTypes();
    }

}
