package com.cskaoyan.mall.mallStart.controller.adminController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminGoodsController {

    @Autowired
    AdminGoodsService adminGoodsService;

    @RequestMapping("admin/goods/list")
    public BaseRespVo listGoods(int page, int limit, Integer goodsSn, String name, String add, String order){

        ListBean listBean = adminGoodsService.listGoods(page,limit,goodsSn,name,add,order);
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

    /**
     * 删除商品
     * @param goods
     * @return
     */
    @RequestMapping("admin/goods/delete")
    public BaseRespVo goodsDelete(@RequestBody Goods goods){
        Integer id = goods.getId();
        adminGoodsService.goodsDelete(id);
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }

    /**
     * 显示评论
     * @param
     * @return
     */
    @RequestMapping("admin/comment/list")
    public BaseRespVo commentList(int page, int limit, Integer userId, Integer valueId, String sort, String order){
        ListBean listBean = adminGoodsService.commentList(page, userId, valueId, limit, sort, order);
        BaseRespVo ok = BaseRespVo.ok(listBean);
        return ok;
    }

    /**
     * 删除评论
     * @return
     */
    @RequestMapping("admin/comment/delete")
    public BaseRespVo deleteComment(@RequestBody Comment comment){

        adminGoodsService.deleteComment(comment.getId());
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }

    @RequestMapping("admin/goods/create")
    public BaseRespVo createGoods(@RequestBody GoodCreatBean goods){
        int value = goods.getGoods().getCounterPrice().intValue();
        int value1 = goods.getGoods().getRetailPrice().intValue();
        if((value<0||value>99999999)||(value1<0||value1>99999999)){
            return BaseRespVo.fail("请输入正确的价格");
        }
        adminGoodsService.createGoods(goods);
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }
}
