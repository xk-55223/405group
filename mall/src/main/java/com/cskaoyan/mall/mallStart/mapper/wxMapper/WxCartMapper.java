package com.cskaoyan.mall.mallStart.mapper.wxMapper;


import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface WxCartMapper {

    List<Cart> CartList(@Param("userId") Integer id);

    void cartUpdate(@Param("cart") Cart cart);

    void cartDelete(@Param("productId") Integer productId);

    void changeIschecked(@Param("isChecked") boolean checked,@Param("productId") Integer productId);

    List<CheckGoodsList> selectCheckedGoodsLists(Integer userId);

    int selectAvailableCouponLength(@Param("userId") Integer userId,@Param("totalPrice") Double goodsTotalPrice);

    BigDecimal selectCouponPrice(@Param("couponId") Integer couponId,@Param("userId") Integer userId);

    Address selectAddressById(Integer addressId);

    List<Cart> selectCartCheckout(Integer userId);

    BigDecimal selectGrouponPrice(Integer grouponRulesId);

    List<Coupon> selectCouponListByUserId(Integer userId);

    void insertOrder(@Param("order") Order order);

    Cart selectCartInfoByCartId(Integer cartId);

    List<Cart> selectUserCheckedCarts(Integer userId);

    void insertOrderGoods(@Param("cart") Cart cart, @Param("now") Date date
            ,@Param("orderId")Integer orderId);

    @Delete("delete from cskaoyan_mall_cart where id = #{id}")
    void deleteCartById(Integer id);
}
