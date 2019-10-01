package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminGoodsMapper {

    /**
     * 商品列表
     */
    @Select("select id, goods_sn as goodsSn, name,category_id as categoryId, brand_id as brandId, gallery, keywords, brief, is_on_sale as isOnSale, sort_order as sortOrder, " +
            "pic_url as picUrl, share_url as shareUrl, is_new as isNew, is_hot as isHot, unit, counter_price as counterPrice, retail_price as retailPrice, detail, add_time as addTime, " +
            "update_time as updateTime, deleted from cskaoyan_mall_goods")
    public List<Goods> listGoods();

    /**
     * 获取商品大分类
     * @return
     */
    @Select("select id as value, name as label from cskaoyan_mall_category where pid = 0")
    public List<GoodsCategoryBean> goodsCategory();

    /**
     * 获取商品小分类
     */
    @Select("select id as value, name as label from cskaoyan_mall_category where pid = #{id}")
    public List<GoodsCategoryBean> goodsDetailCategory(int id);

    /**
     * 获取商品品牌列表
     */
    @Select("select id as value, name as label from cskaoyan_mall_brand")
    public List<GoodsCategoryBean> goodsBrand();

    /**
     * 根据id获取某个商品
     */
    @Select("select id, goods_sn as goodsSn, name,category_id as categoryId, brand_id as brandId, gallery, keywords, brief, is_on_sale as isOnSale, sort_order as sortOrder, " +
            "pic_url as picUrl, share_url as shareUrl, is_new as isNew, is_hot as isHot, unit, counter_price as counterPrice, retail_price as retailPrice, detail, add_time as addTime, " +
            "update_time as updateTime, deleted from cskaoyan_mall_goods where id = #{id}")
    public Goods listGoodsById(int id);

    /**
     * 根据规格id获取分类
     */
    @Select("select pid from cskaoyan_mall_category where id = #{categoryId}")
    public Category goodCategory(int categoryId);

    /**
     *获取分类id组
     */
    @Select("select id from cskaoyan_mall_category where id = #{pid}")
    List<Category> goodCategories(Integer pid);

    @Select("select id, goods_id as goodsId, attribute, value, add_time as addTime, update_time as updateTime" +
            "deleted from cskaoyan_mall_goods_attribute where goods_id = #{id}")
    List<GoodsAttribute> goodAttributes(int id);

    @Select("select id, goods_id as goodsId, specification, value, pic_url as picUrl, add_time as addTime, update_time as" +
            " updateTime, deleted from cskaoyan_mall_goods_specification where goods_id = #{id}")
    List<GoodsSpecification> goodSpecification(int id);

    @Select("select id, goods_id as GoodsId, specifications, price, number, url, add_time as addTime, update_time as updateTime, " +
            "deleted from cskaoyan_mall_goods_product where goods_id = #{id}")
    List<GoodsProduct> goodProducts(int id);
}
