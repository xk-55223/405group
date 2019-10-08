package com.cskaoyan.mall.mallStart.mapper.wxMapper;

import com.cskaoyan.mall.mallStart.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxBrandMapper {
    List<Brand> selectBrandAll();

    Brand selectBrandById(@Param("id") int id);

    List<Topic> selectTopicAll();

    Topic selectTopicById(@Param("id") int id);

    List<Topic> selectTopicRelated(@Param("id") int id);

    List<CommentLJQ> selectCommentsByValueId(@Param("valueId") Integer valueId,@Param("type") Integer type,@Param("showType") Integer showType);

    Integer insertComment(@Param("comment") Comment comment);
}
