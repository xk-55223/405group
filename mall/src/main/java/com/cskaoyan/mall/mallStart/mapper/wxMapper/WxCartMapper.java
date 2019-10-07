package com.cskaoyan.mall.mallStart.mapper.wxMapper;


import com.cskaoyan.mall.mallStart.bean.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxCartMapper {

    List<Cart> CartList();

    void cartUpdate(@Param("cart") Cart cart);

    void cartDelete(@Param("productId") Integer productId);
}
