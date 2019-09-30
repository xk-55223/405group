package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.service.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminGoodsController {

    @Autowired
    AdminGoodsService adminGoodsService;

    @RequestMapping("admin/goods/list")
    public BaseRespVo listGoods(int page, int limit, String add, String order){

        ListBean listBean = adminGoodsService.listGoods(page,limit,add,order);
        BaseRespVo ok = BaseRespVo.ok(listBean);
        return ok;
    }

    /**
     * 获取商品类目
     * @return
     */
    @RequestMapping("admin/goods/catAndBrand")
    public BaseRespVo cartAndBrand(){
        //规格
        List<GoodsCategoryBean> goodsCategoryBeans = adminGoodsService.carAndBrand();
        //品牌
        List<GoodsCategoryBean> goodsCategoryBeans1 = adminGoodsService.goodsBrand();

        CategoryAndBrandBean categoryAndBrandBean = new CategoryAndBrandBean();
        categoryAndBrandBean.setCategoryList(goodsCategoryBeans);
        categoryAndBrandBean.setBrandList(goodsCategoryBeans1);

        BaseRespVo ok = BaseRespVo.ok(categoryAndBrandBean);
        return ok;
    }

    /**
     * 修改商品时显示商品信息
     */
    @RequestMapping("admin/goods/detail")
    public BaseRespVo goodInfo(int id){
        UpdateGoodsInfo updateGoodsInfo = adminGoodsService.goodInfo(id);
        BaseRespVo ok = BaseRespVo.ok(updateGoodsInfo);
        return ok;
    }
}
