package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.bean.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface AdminFirstPageMapper {
    @Select("select count(id) from cskaoyan_mall_user ")
    int getUserTotal();

    @Select("select count(id) from cskaoyan_mall_goods ")
    int getGoodsTotal();

    @Select("select count(id) from cskaoyan_mall_goods_product")
    int getProductTotal();

    @Select("select count(id) from cskaoyan_mall_order")
    int getOrderTotal();

    @Select("select username,password from cskaoyan_mall_admin where username = #{admin.username} and password = #{admin.password}")
    Admin queryAdmin(@Param("admin") Admin admin);

    @Insert("insert into cskaoyan_mall_log (admin,ip,type,action,status,result,add_time,update_time) values (#{log.admin},#{log.ip},#{log.type},#{log.action}," +
            "#{log.status},#{log.result},#{log.addTime},#{log.updateTime} )")
    void addLog(@Param("log") Log log);
}
