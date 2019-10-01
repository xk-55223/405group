package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;

import java.util.List;

public interface AdminMallService {
    List<Region> selectRegions();

    List<Brand> selectBrands(Brand brand);

    List<Category> selectCategorys();

    List<CategoryType> selectCategoryTypes();

    void deleteCategory(Category category);

    List<Order> selectOrders(Order order);

    List<Issue> selectIssues(Issue issue);

    Issue insertIssue(Issue issue);

    List<Keyword> selectKeywords(Keyword keyword);

    Keyword insertKeyword(Keyword keyword);
}
