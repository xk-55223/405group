package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Cart;
import com.cskaoyan.mall.mallStart.bean.CartListBean;
import com.cskaoyan.mall.mallStart.service.wxService.WxCartServiceImpl;
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
        CartListBean cartListBean = wxCartService.cartList();
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
        List<Integer> productIds = (List<Integer>) map.get("productIds");
        CartListBean cartListBean = wxCartService.cartDelete(productIds);
        BaseRespVo ok = BaseRespVo.ok(cartListBean);
        return ok;
    }
}
