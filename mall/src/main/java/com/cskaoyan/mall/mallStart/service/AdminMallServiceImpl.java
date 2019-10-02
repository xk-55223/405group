package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminMallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class AdminMallServiceImpl implements AdminMallService {
    @Autowired
    AdminMallMapper mapper;

    @Override
    public List<Region> selectRegions() {
        List<Region> regions = mapper.selectRegions();
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
        /*deleteStaticFile(category.getIconUrl());
        deleteStaticFile(category.getPicUrl());
        List<Category> childrens = category.getChildren();
        for (Category children : childrens) {
            mapper.deleteCategoryById(children.getId());
            deleteStaticFile(children.getIconUrl());
            deleteStaticFile(children.getPicUrl());
        }*/
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

    @Override
    public OrderDetail selectOrderDetail(int id) {
        OrderDetail orderDetail = new OrderDetail();
        Order order = mapper.selectOrderById(id);
        User user = mapper.selectUserById(order.getUserId());
        List<OrderGoods> orderGoods = mapper.selectOrderGoods(id);
        orderDetail.setOrder(order);
        orderDetail.setOrderGoods(orderGoods);
        orderDetail.setUser(user);
        return orderDetail;
    }

    @Override
    public void updateIssue(Issue issue) {
        mapper.updateIssue(issue);
    }

    @Override
    public void deleteIssueById(Integer id) {
        mapper.deleteIssueById(id);
    }

    @Override
    public Brand insertBrand(Brand brand) {
        Date date = new Date();
        brand.setAddTime(date);
        brand.setUpdateTime(date);
        mapper.insertBrand(brand);
        return brand;
    }

    @Override
    public Brand updateBrand(Brand brand) {
        mapper.updateBrand(brand);
        Brand newBrand = mapper.selectBrandById(brand.getId());
        return newBrand;
    }

    @Override
    public void deleteBrand(Brand brand) {
        mapper.deleteBrandById(brand.getId());
    }

    @Override
    public Category insertCategory(Category category) {
        Date date = new Date();
        category.setAddTime(date);
        category.setUpdateTime(date);
        mapper.insertCategory(category);
        return category;
    }

   /* private void deleteStaticFile(String url) {
        File file = new File(url);
        file.delete();
    }*/

}
