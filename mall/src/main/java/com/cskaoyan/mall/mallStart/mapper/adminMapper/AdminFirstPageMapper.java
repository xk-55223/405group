package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminFirstPageMapper {

    @Select("select count(id) from cskaoyan_mall_user ")
    int getUserTotal();

    @Select("select count(id) from cskaoyan_mall_goods ")
    int getGoodsTotal();

    @Select("select count(id) from cskaoyan_mall_goods_product")
    int getProductTotal();

    @Select("select count(id) from cskaoyan_mall_order")
     int getOrderTotal();


    // shiro 用到的
    @Select("select password from cskaoyan_mall_user where username = #{username}")
    String selectPasswordByUserName(String username);
    //shiro 用到的
    @Select("select DISTINCT permission\n" +
            "from cskaoyan_mall_user u \n" +
            "LEFT JOIN cskaoyan_mall_user_role ur\n" +
            "on u.id = ur.user_id\n" +
            "LEFT JOIN cskaoyan_mall_role r\n" +
            "on ur.role_id = r.id\n" +
            "LEFT JOIN cskaoyan_mall_permission p\n" +
            "on p.role_id = r.id\n" +
            "where u.username = #{username}")
    List<String> selectPermissionByUserName(String username);

    @Select("select avatar from cskaoyan_mall_user where username = #{username}")
    String selectAvatarByUserName(String username);

    @Select("select DISTINCT r.`name`\n" +
            "from cskaoyan_mall_user u \n" +
            "LEFT JOIN cskaoyan_mall_user_role ur\n" +
            "on u.id = ur.user_id\n" +
            "LEFT JOIN cskaoyan_mall_role r\n" +
            "on ur.role_id = r.id\n" +
            "where u.username = #{username}")
    List<String> selectRolesByUsername(String username);
}
