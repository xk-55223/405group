package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Cart;
import com.cskaoyan.mall.mallStart.bean.CartCheckedBean;
import com.cskaoyan.mall.mallStart.bean.CartListBean;
import com.cskaoyan.mall.mallStart.service.wxService.WxCartServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WxCartController {
    @Autowired
    WxCartServiceImpl wxCartService;
    //显示购物车
    @RequestMapping("wx/cart/index")
    public BaseRespVo CartList(){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        CartListBean cartListBean = wxCartService.cartList(userId);
        BaseRespVo ok = BaseRespVo.ok(cartListBean);
        return ok;
    }

    @RequestMapping("wx/cart/update")
    public BaseRespVo cartUpdate(@RequestBody Cart cart){
        wxCartService.cartUpdate(cart);
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }

    @RequestMapping("wx/cart/delete")
    public BaseRespVo cartDelete(@RequestBody Map<String,Object> map){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        CartListBean cartListBean = wxCartService.cartDelete(productIds,userId);
        BaseRespVo ok = BaseRespVo.ok(cartListBean);
        return ok;
    }

    @RequestMapping("wx/cart/checked")
    public BaseRespVo cartChecked(@RequestBody CartCheckedBean productIds){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        CartListBean cartListBean = wxCartService.cartChecked(productIds,userId);
        BaseRespVo ok = BaseRespVo.ok(cartListBean);
        return ok;
    }


}
