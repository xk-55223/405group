package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface WxHomeService {
    WxIndexInfo homeIndex();

    GoodsCount goodsCount();

    Map selectBrandAll(BrandPageInfo pageInfo);

    Map selectBrandById(int id);

    Map selectTopicAll(BrandPageInfo pageInfo);

    Map selectTopicById(int id);

    Map selectCommentsByValueId(BrandPageInfo pageInfo, int valueId);

    Comment commentPost(Comment comment, HttpServletRequest request);

    List<Topic> selectTopicRelated(int id);

    SearchIndexInfo searchIndex(int userId);

    List<String> searchHelper(String keyword);


    GoodsListInfo goodsList(Integer userId, String keyword, FromPageInfo info, Integer categoryId, Integer brandId);

    void searchClearhistory(int userId);

    GoodsCategoryInfo goodsCategory(Integer id);

    CouponListInfo couponList(FromPageInfo fromPageInfo);

    UserLoginInfo selectUserMessage(User user);

    UserIndexInfo selectUserIndexInfo(int userId);

    String couponReceive(Integer userId, Integer couponId);

    GrouponPageInfo grouponList(FromPageInfo fromPageInfo);
}
