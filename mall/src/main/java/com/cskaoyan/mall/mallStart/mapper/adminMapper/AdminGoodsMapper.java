package com.cskaoyan.mall.mallStart.mapper.adminMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminGoodsMapper {

    /**
     * 商品列表
     */
    public List<Goods> listGoods(@Param("goodsSn")Integer goodsSn, String name);

    /**
     * 获取商品大分类
     *
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

    public Goods listGoodsById(@Param("id") int id);

    /**
     * 根据规格id获取分类
     */
    @Select("select id,name,keywords,`desc`,pid,icon_url as iconUrl, pic_url as picUrl, level,sort_order as\n" +
            "        sortOrder, add_time as addTime, update_time as updateTime, `deleted` from cskaoyan_mall_category where id = #{categoryId}")
    public Category goodCategory(int categoryId);

    /**
     * 获取分类id组
     */
    @Select("select id from cskaoyan_mall_category where id = #{pid}")
    List<Category> goodCategories(Integer pid);

    /**
     * 获取属性集合
     * @param id
     * @return
     */
    @Select("select id, goods_id as goodsId, attribute, value, add_time as addTime, update_time as updateTime" +
            "deleted from cskaoyan_mall_goods_attribute where goods_id = #{id}")
    List<GoodsAttribute> goodAttributes(int id);

    /**
     * 获取特质集合
     * @param id
     * @return
     */
    @Select("select id, goods_id as goodsId, specification, value, pic_url as picUrl, add_time as addTime, update_time as" +
            " updateTime, deleted from cskaoyan_mall_goods_specification where goods_id = #{id}")
    List<GoodsSpecification> goodSpecification(int id);

    @Select("select id, goods_id as goodsId, specifications, price, number, url, add_time as addTime, update_time as updateTime, " +
            "deleted from cskaoyan_mall_goods_product where goods_id = #{id}")
    List<GoodsProduct> goodProducts(int id);

    @Delete("delete from cskaoyan_mall_goods where id = #{id}")
    void goodsDelete(int id);

    @Delete("delete from cskaoyan_mall_goods_attribute where goods_id = #{id}")
    void goodsAttributeDelete(int id);

    @Delete("delete from cskaoyan_mall_goods_product where goods_id = #{id}")
    void goodsProductDelete(int id);

    @Delete("delete from cskaoyan_mall_goods_specification where goods_id = #{id}")
    void goodsSpecificationDelete(int id);

    /**
     * 显示评论
     * @param userId
     * @param valueId
     * @return
     */
    List<Comment> commentsList(@Param("userId") Integer userId,@Param("valueId")  Integer valueId);

    /**
     * 删除评论
     * @param id
     */
    void deleteComment(@Param("id") Integer id);

    /**
     * 添加商品
     * @param goods
     */
    void insertGoods(@Param("goods") Goods goods);

    void insertAttribute(@Param("attribute") GoodsAttribute attribute);

    void insertProducts(@Param("product") GoodsProduct product);

    void insertSpecification(@Param("specification") GoodsSpecification specification);

    Goods listGoodsById(@Param("id") Integer id);

    List<Goods> selectHotGoods(boolean hot);

    List<Goods> selectNewGoods(boolean isNew);

    @Select("select count(id) as goodsCount from cskaoyan_mall_goods")
    GoodsCount selectGoodsCount();

    List<Goods> selectGoodsConditioned(@Param("keyword") String keyword
            ,@Param("categoryId") Integer categoryId
            ,@Param("pageInfo") FromPageInfo pageInfo
            ,@Param("brandId") Integer brandId);

    List<Category> selectGoodsCategorys(@Param("keyword") String keyword);
    void updateAttribute(@Param("attribute") GoodsAttribute attribute, @Param("id") Integer id);

    void updateGoods(@Param("goods") Goods goods1,@Param("id") Integer id);

    void updateProduct(@Param("product") GoodsProduct product,@Param("id") Integer id);

    void updateSpecification(@Param("specification") GoodsSpecification specification,@Param("id") Integer id);

    List<CommentBean> listCommentBeanByGoodsId(int goodsId);

    @Select("select count(id) from cskaoyan_mall_comment where value_id = #{goodsId}")
    int countCommentByGoodsId(int goodsId);

    @Select("select category_id from cskaoyan_mall_goods where id = #{id}")
    int selectCategoryIdByGoodsId(int id);

    List<Goods> selectGoodsByCategoryId(int categoryId);

    @Select("select id, goods_id as goodsId, specifications, price, number, url, add_time as addTime, update_time as updateTime, " +
            "deleted from cskaoyan_mall_goods_product where id = #{id}")
    GoodsProduct selectGoodsProductById(Integer productId);

    @Select("select id from cskaoyan_mall_cart where goods_id = #{param1} and number = #{param2} and user_id = #{param3}")
    int selectCartIdByParam(Integer goodsId, Integer number, int userId);

    @Select("select count(id) from cskaoyan_mall_cart where goods_id = #{param1} and product_id = #{param2} and user_id = #{param3}")
    int isExistGoodsInCart(Integer goodsId, Integer productId, int userId);

    @Update("update cskaoyan_mall_cart set number = number + #{param1} where goods_id = #{param2} and product_id = #{param3} and user_id = #{param4}")
    void updateGoodsNumInCart(short number, Integer goodsId, Integer productId, int userId);

    @Select("select number from cskaoyan_mall_goods_product where id = #{productId}")
    int queryNumByProductId(Integer productId);
}

