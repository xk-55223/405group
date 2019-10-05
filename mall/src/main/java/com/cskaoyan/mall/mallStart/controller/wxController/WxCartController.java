package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.CartListBean;
import com.cskaoyan.mall.mallStart.service.wxService.WxCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
