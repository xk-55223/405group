package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminMallMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Brand> selectBrands( Brand brand) {
        System.out.println(brand);
        return mapper.selectBrands(brand);
    }

    @Override
    public List<Category> selectCategorys() {
        return mapper.selectCategorys();
    }

    @Override
    public List<CategoryType> selectCategoryTypes() {
        return mapper.selectCategoryTypes();
    }

    @Override
    public void deleteCategory(Category category) {
        mapper.deleteCategoryById(category.getId());
        deleteStaticFile(category.getIconUrl());
        deleteStaticFile(category.getPicUrl());
        List<Category> childrens = category.getChildren();
        for (Category children : childrens) {
            mapper.deleteCategoryById(children.getId());
            deleteStaticFile(children.getIconUrl());
            deleteStaticFile(children.getPicUrl());
        }
    }

    @Override
    public List<Order> selectOrders(Order order) {
        return mapper.selectOrders(order);
    }

    @Override
    public List<Issue> selectIssues(Issue issue) {
        return mapper.selectIssues(issue);
    }

    @Override
    public Issue insertIssue(Issue issue) {
        issue.setAddTime(new Date());
        issue.setUpdateTime(new Date());
        issue.setDeleted(false);
        mapper.insertIssue(issue);
        return issue;
    }

    @Override
    public List<Keyword> selectKeywords(Keyword keyword) {
        return mapper.selectKeywords(keyword);
    }

    @Override
    public Keyword insertKeyword(Keyword keyword) {
        Date nowtime = new Date();
        keyword.setAddTime(nowtime);
        keyword.setUpdateTime(nowtime);
        mapper.insertKeyword(keyword);
        return keyword;
    }

    private void deleteStaticFile(String url) {
        File file = new File(url);
        file.delete();
    }

}
