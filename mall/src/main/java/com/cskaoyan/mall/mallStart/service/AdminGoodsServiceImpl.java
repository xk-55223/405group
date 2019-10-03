package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminGoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    AdminGoodsMapper adminGoodsMapper;

    @Override
    public ListBean listGoods(int page, int limit, Integer goodsSn, String name, String add, String order) {
        PageHelper.startPage(page,limit);
        List<Goods> goods = adminGoodsMapper.listGoods(goodsSn, name);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);
        long total = goodsPageInfo.getTotal();

        ListBean<Goods> goodsListBean = new ListBean<>();
        goodsListBean.setItems(goods);
        goodsListBean.setTotal(total);
        return goodsListBean;
    }

    @Override
    public List< GoodsCategoryBean> carAndBrand() {
        List<GoodsCategoryBean> goodsCategoryBean = adminGoodsMapper.goodsCategory();
        for (GoodsCategoryBean categoryBean : goodsCategoryBean) {
            List<GoodsCategoryBean> goodsCategoryBeans = adminGoodsMapper.goodsDetailCategory(categoryBean.getValue());
            categoryBean.setChildren(goodsCategoryBeans);
        }
        return goodsCategoryBean;
    }

    @Override
    public List<GoodsCategoryBean> goodsBrand() {
        List<GoodsCategoryBean> goodsCategoryBeans = adminGoodsMapper.goodsBrand();
        return goodsCategoryBeans;
    }

    @Override
    public UpdateGoodsInfo goodInfo(int id) {
        //根据id查找到商品属性
        Goods goods = adminGoodsMapper.listGoodsById(id);
        //根据商品categoryid找到商品的分类
        Category category = adminGoodsMapper.goodCategory(goods.getCategoryId());
        //找到规格pid相同的id
        List<Category> categories = adminGoodsMapper.goodCategories(category.getPid());
        List<Integer> idList = new ArrayList();
        for (Category category1 : categories) {
            Integer id1 = category1.getId();
            idList.add(id1);
        }
        //根据id找atributes
        List<GoodsAttribute > goodsAttribute = adminGoodsMapper.goodAttributes(id);
        //根据id找specification
        List<GoodsSpecification> goodsSpecification = adminGoodsMapper.goodSpecification(id);
        //找product
        List<GoodsProduct> goodsProducts = adminGoodsMapper.goodProducts(id);

        UpdateGoodsInfo updateGoodsInfo = new UpdateGoodsInfo();
        updateGoodsInfo.setCategoryIds(idList);
        updateGoodsInfo.setGoods(goods);
        updateGoodsInfo.setAttributes(goodsAttribute);
        updateGoodsInfo.setSpecifications(goodsSpecification);
        updateGoodsInfo.setProducts(goodsProducts);

        return updateGoodsInfo;
    }

    /**
     *删除商品
     */
    @Override
    public void goodsDelete(int id) {
        //删除商品信息
        adminGoodsMapper.goodsDelete(id);
        //删除attribute
        adminGoodsMapper.goodsAttributeDelete(id);
        //删除product
        adminGoodsMapper.goodsProductDelete(id);
        //删除specifcation
        adminGoodsMapper.goodsSpecificationDelete(id);
    }

    @Override
    public ListBean commentList(int page,Integer userId, Integer valueId,int limit,String sort,String order) {
        PageHelper.startPage(page,limit);
        List<Comment> comments = adminGoodsMapper.commentsList(userId, valueId);
        PageInfo<Comment> commentsPageInfo = new PageInfo<>(comments);
        long total = commentsPageInfo.getTotal();

        ListBean<Comment> commentListBean = new ListBean<>();
        commentListBean.setItems(comments);
        commentListBean.setTotal(total);
        return commentListBean;
    }

    @Override
    public void deleteComment(Integer id) {
        adminGoodsMapper.deleteComment(id);
    }

    @Override
    public void createGoods(GoodCreatBean goods) {
        Goods goods1 = goods.getGoods();
        List<GoodsAttribute> attributes = goods.getAttributes();
        List<GoodsProduct> products = goods.getProducts();
        List<GoodsSpecification> specifications = goods.getSpecifications();
        Date date = new Date();
        //sortOrder未知
        goods1.setSortOrder(Short.valueOf("12"));
        goods1.setAddTime(date);
        goods1.setUpdateTime(date);
        adminGoodsMapper.insertGoods(goods1);

        for (GoodsAttribute attribute : attributes) {
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            attribute.setGoodsId(goods1.getId());
            adminGoodsMapper.insertAttribute(attribute);
        }
        for (GoodsProduct product : products) {
            product.setAddTime(date);
            product.setUpdateTime(date);
            goods1.getId();
            product.setGoodsId(goods1.getId());
            adminGoodsMapper.insertProducts(product);
        }

        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(goods1.getId());
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            adminGoodsMapper.insertSpecification(specification);
        }
    }


}
