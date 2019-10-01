package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Brand;
import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.CategoryType;
import com.cskaoyan.mall.mallStart.bean.Region;

import java.util.List;

public interface AdminMallService {
    List<Region> selectRegions();

    List<Brand> selectBrands();

    List<Category> selectCategorys();

    List<CategoryType> selectCategoryTypes();

    void deleteCategory(Category category);
}
