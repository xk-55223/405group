package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Category;
import com.cskaoyan.mall.mallStart.bean.Goods;
import com.cskaoyan.mall.mallStart.bean.WxGoodsDetail;
import com.cskaoyan.mall.mallStart.service.wxService.WxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BaseRespVo cartGoodsCount(HttpServletRequest request){
       int a =0;
       if(request.getSession().getAttribute("userId")!=null){
            a = (int) request.getSession().getAttribute("userId");
       }

       int goodsCount = service.countCartGoods(a);
        return BaseRespVo.ok(goodsCount);
    }

    @RequestMapping("wx/catalog/current")
    public BaseRespVo currentCatalog(int id){
        Map<String,Object> map = service.currentCatalog(id);
        return BaseRespVo.ok(map);
    }

    @RequestMapping("wx/catalog/index")
    public BaseRespVo indexCatalog(){
        List<Category> categories=service.currentCategoryList();
        Category category = categories.get(0);
        Map<String, Object> stringObjectMap = service.currentCatalog(category.getId());
        stringObjectMap.put("categoryList",categories);
        return BaseRespVo.ok(stringObjectMap);
    }

    @RequestMapping("wx/goods/detail")
    public BaseRespVo goodsDetail(int id, HttpServletRequest request){
        int userId = -1;
         if(request.getSession().getAttribute("userId")!=null){
             userId= (int) request.getSession().getAttribute("userId");
         }
        WxGoodsDetail goods= service.getWxGoodsDetail(id,userId);
        return BaseRespVo.ok(goods);
    }

    @RequestMapping("/wx/goods/related")
    public BaseRespVo goodsRelated(int id){
       List<Goods>  goodsList = service.goodsRelated(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsList",goodsList);
        return BaseRespVo.ok(map);
    }
    
}
