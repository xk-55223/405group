package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMallMapper {

    List<Region> selectRegions();

    List<Region> selectCitysByPid(int pid) ;

    List<Region> selectTownsByCode(int code) ;

    List<Brand> selectBrands(@Param("brand") Brand brand);

    List<Category> selectCategorys();

    List<Category> selectCategoryChildren(int pid);

    List<CategoryType> selectCategoryTypes();

    void deleteCategoryById(Integer id);

    List<Order> selectOrders(@Param("order") Order order);

    List<Issue> selectIssues(@Param("issue") Issue issue);

    void insertIssue(@Param("issue")Issue issue);

    List<Keyword> selectKeywords(@Param("keyword") Keyword keyword);

    void insertKeyword(@Param("keyword") Keyword keyword);

    Order selectOrderById(int id);

    User selectUserById(Integer userId);

    List<OrderGoods> selectOrderGoods(int id);

    void updateIssue(@Param("issue") Issue issue);

    void deleteIssueById(Integer id);

    void insertBrand(@Param("brand") Brand brand);

    Brand selectBrandById(Integer id);

    void updateBrand(@Param("brand") Brand brand);

    void deleteBrandById(Integer id);

    void insertCategory(@Param("category") Category category);
}
