package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.Brand;
import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.CategoryType;
import com.cskaoyan.mall.mallStart.bean.Region;

import java.util.List;

public interface AdminMallMapper {

    List<Region> selectRegions();

    List<Region> selectCitysByPid(int pid) ;

    List<Region> selectTownsByCode(int code) ;

    List<Brand> selectBrands();

    List<Category> selectCategorys();

    List<Category> selectCategoryChildren(int pid);

    List<CategoryType> selectCategoryTypes();

    void deleteCategoryById(Integer id);
}
