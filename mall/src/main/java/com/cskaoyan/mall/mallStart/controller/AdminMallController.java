package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.AdminMallService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
public class AdminMallController {

    @Autowired
    AdminMallService service;


    // 行政区域的查询啊显示
    @RequestMapping("admin/region/list")
    public BaseRespVo regionlist() {
        List<Region> regions = service.selectRegions();
        BaseRespVo result = BaseRespVo.ok(regions);
        return result;
    }

    // 品牌制造商的查询和显示
    @RequestMapping("admin/brand/list")
    public BaseRespVo brandList(FromPageInfo page,Brand brand) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Brand> brands = service.selectBrands(brand);
        PageInfo pageInfo = new PageInfo();
        long total = pageInfo.getTotal();
        ListBean brandList = new ListBean<>();
        brandList.setTotal((int)total);
        brandList.setItems(brands);
        BaseRespVo result = BaseRespVo.ok(brandList);
        return result;
    }

    // 所有商品的查询
    @RequestMapping("admin/category/list")
    public BaseRespVo categoryList() {
        List<Category> categories = service.selectCategorys();
        BaseRespVo result = BaseRespVo.ok(categories);
        return result;
    }

    // 商品类目中的商品种类显示
    @RequestMapping("admin/category/l1")
    public BaseRespVo categoryl1() {
        List<CategoryType> categorieTypes = service.selectCategoryTypes();
        BaseRespVo result = BaseRespVo.ok(categorieTypes);
        return result;
    }

    // 商品类目的删除 还没有写完
    @RequestMapping("admin/category/delete")
    public BaseRespVo categoryDelete(Category category) {
        service.deleteCategory(category);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }


    // 订单管理的查询和显示接口
    @RequestMapping("admin/order/list")
    public BaseRespVo ordList(FromPageInfo page, Order order) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Order> orders = service.selectOrders(order);
        PageInfo pageInfo = new PageInfo();
        long total = pageInfo.getTotal();
        ListBean orderList = new ListBean<>();
        orderList.setTotal((int)total);
        orderList.setItems(orders);
        BaseRespVo result= BaseRespVo.ok(orderList);
        return result;
    }

    // 通用问题的查询和显示
    @RequestMapping("admin/issue/list")
    public BaseRespVo issueList(FromPageInfo page, Issue issue) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Issue> issues = service.selectIssues(issue);
        PageInfo pageInfo = new PageInfo();
        long total = pageInfo.getTotal();
        ListBean issueList = new ListBean<>();
        issueList.setTotal((int)total);
        issueList.setItems(issues);
        BaseRespVo result= BaseRespVo.ok(issueList);
        return result;
    }

    // 添加通用问题
    @RequestMapping("admin/issue/create")
    public BaseRespVo issueCreate(@RequestBody Issue issue) {
        Issue newIssue = service.insertIssue(issue);
        BaseRespVo result = BaseRespVo.ok(newIssue);
        return result;
    }

    @RequestMapping("admin/keyword/list")
    public BaseRespVo keywordList(FromPageInfo page, Keyword keyword) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        List<Keyword> keywords = service.selectKeywords(keyword);
        PageInfo pageInfo = new PageInfo();
        long total = pageInfo.getTotal();
        ListBean keywordList = new ListBean<>();
        keywordList.setTotal((int)total);
        keywordList.setItems(keywords);
        BaseRespVo result= BaseRespVo.ok(keywordList);
        return result;
    }

    @RequestMapping("admin/keyword/create")
    public BaseRespVo keywordCreate(@RequestBody Keyword keyword) {
        Keyword newKeyword = service.insertKeyword(keyword);
        BaseRespVo result = BaseRespVo.ok(newKeyword);
        return result;
    }
}
