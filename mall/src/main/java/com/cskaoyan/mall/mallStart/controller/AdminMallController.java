package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.AdminMallService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminMallController {

    @Autowired
    AdminMallService service;

    @RequestMapping("admin/region/list")
    public BaseRespVo regionlist() {
        List<Region> regions = service.selectRegions();
        BaseRespVo result = BaseRespVo.ok(regions);
        return result;
    }

    @RequestMapping("admin/brand/list")
    public BaseRespVo brandList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Brand> brands = service.selectBrands();
        PageInfo pageInfo = new PageInfo();
        long total = pageInfo.getTotal();
        BrandList brandList = new BrandList();
        brandList.setTotal((int)total);
        brandList.setItems(brands);
        BaseRespVo result = BaseRespVo.ok(brandList);
        return result;
    }

    @RequestMapping("admin/category/list")
    public BaseRespVo categoryList() {
        List<Category> categories = service.selectCategorys();
        BaseRespVo result = BaseRespVo.ok(categories);
        return result;
    }

    @RequestMapping("admin/category/l1")
    public BaseRespVo categoryl1() {
        List<CategoryType> categorieTypes = service.selectCategoryTypes();
        BaseRespVo result = BaseRespVo.ok(categorieTypes);
        return result;
    }
}
