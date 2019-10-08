package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.Goods;
import com.cskaoyan.mall.mallStart.bean.WxGoodsDetail;
import com.cskaoyan.mall.mallStart.service.wxService.WxCategoryService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WxCategoryController {
    @Autowired
    WxCategoryService service;

   @RequestMapping("wx/cart/goodscount")
    public BaseRespVo cartGoodsCount(){
       Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
       if (userId == null) return BaseRespVo.ok(0);
       int goodsCount = service.countCartGoods(userId);
        return BaseRespVo.ok(goodsCount);
    }

    @RequestMapping("wx/catalog/current")
    public BaseRespVo currentCatalog(int id){
        Map<String,Object> map = service.currentCatalog(id);
        return BaseRespVo.ok(map);
    }
    //分类
    @RequestMapping("wx/catalog/index")
    public BaseRespVo indexCatalog(){
        List<Category> categories=service.currentCategoryList();
        Category category = categories.get(0);
        Map<String, Object> stringObjectMap = service.currentCatalog(category.getId());
        stringObjectMap.put("categoryList",categories);
        return BaseRespVo.ok(stringObjectMap);
    }
    //商品详情
    @RequestMapping("wx/goods/detail")
    public BaseRespVo goodsDetail(int id){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        WxGoodsDetail goods= service.getWxGoodsDetail(id,userId);
        return BaseRespVo.ok(goods);
    }

    //相关商品
    @RequestMapping("/wx/goods/related")
    public BaseRespVo goodsRelated(int id){
       List<Goods>  goodsList = service.goodsRelated(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsList",goodsList);
        return BaseRespVo.ok(map);
    }


    //先查询本用户有没有收藏这个商品，有则删除，没有则添加
    @RequestMapping("wx/collect/addordelete")
    public BaseRespVo collectGoods(@RequestBody Map<String,Integer> map1,HttpServletRequest request){
        Integer type = map1.get("type");
        Integer valueId = map1.get("valueId");
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        String i =  service.collectGoods(valueId,type,userId);
        HashMap<String, String> map = new HashMap<>();
        map.put("type",i);
        return BaseRespVo.ok(map);
   }

   @RequestMapping("wx/cart/add")
    public BaseRespVo addGoodsToCart(@RequestBody Map<String,Object> map ){
       Integer goodsId = (Integer) map.get("goodsId");
       int i = (Integer) map.get("number");
       short number = (short) i;
       Integer productId = (Integer) map.get("productId");
       int storeNum = service.queryNumByGoodsProductId(productId);
       if(storeNum - number < 0){
           return BaseRespVo.fail("库存不够了，换一个吧");
       }
       Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
       int num = service.addGoodsToCart(goodsId,number,productId,userId);
       return BaseRespVo.ok(num);
   }


   @RequestMapping("wx/cart/fastadd")
    public BaseRespVo fastaddToCart(@RequestBody Map<String,Object> map ){
       Integer goodsId = (Integer) map.get("goodsId");
       int i = (Integer) map.get("number");
       short number = (short) i;
       Integer productId = (Integer) map.get("productId");
       int storeNum = service.queryNumByGoodsProductId(productId);
       if(storeNum - number < 0){
           return BaseRespVo.fail("库存不够了，换一个吧");
       }
       Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
       int id = service.fastaddToCart(goodsId,number,productId,userId);
       return BaseRespVo.ok(id);
   }
}
