package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxBrandMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxHomeServiceImpl implements WxHomeService {
    @Autowired
    AdminMallMapper mallMapper;

    @Autowired
    AdminGoodsMapper goodsMapper;

    @Autowired
    AdminGeneralizeMapper generalizeMapper;

    @Autowired
    WxBrandMapper wxBrandMapper;

    @Autowired
    AdminUserMapper userMapper;

    @Override
    public GoodsCount goodsCount() {
        return goodsMapper.selectGoodsCount();
    }

    @Override
    public Map selectBrandAll(BrandPageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<Brand> brands = wxBrandMapper.selectBrandAll();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        long total = brandPageInfo.getTotal();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("totalPages", Math.ceil(total * 1.0 / pageInfo.getSize()));
        resultMap.put("brandList", brands);
        return resultMap;
    }

    @Override
    public SearchIndexInfo searchIndex(int userId) {
        List<Keyword> hotKeywords = mallMapper.selectHotKeywords(true);
        Keyword defaultKeyword = mallMapper.selectDefaultKeyword();
        List<Keyword> historyKeywords = mallMapper.selectHistoryKeywords(userId);
        SearchIndexInfo indexInfo = new SearchIndexInfo();
        indexInfo.setHotKeywordList(hotKeywords);
        indexInfo.setDefaultKeyword(defaultKeyword);
        indexInfo.setHistoryKeywordList(historyKeywords);
        return indexInfo;
    }

    @Override
    public List<String> searchHelper(String keyword) {
        return mallMapper.selectStringKeywords(keyword);
    }

    @Override
    public GoodsListInfo goodsList(Integer userId, String keyword, FromPageInfo info
            , Integer categoryId, Integer brandId) {
        GoodsListInfo goodsListInfo = new GoodsListInfo();
        PageHelper.startPage(info.getPage(), info.getLimit());
        List<Goods> goods = goodsMapper.selectGoodsConditioned(keyword, categoryId, info, brandId);
        List<Category> categories = null;
        if (keyword != null) {
            categories = goodsMapper.selectGoodsCategorys(keyword);
        }
        BeansManager beansManager = new BeansManager();
        ListBean listBean = beansManager.toListBean(goods);
        int total = (int) listBean.getTotal();
        goodsListInfo.setCount(total);
        goodsListInfo.setFilterCategoryList(categories);
        goodsListInfo.setGoodsList(goods);
        // 添加搜索历史, 在搜索页面是会传入keyword。
        // 如果不是在搜索页面调用这个方法则不传入keyword，则不添加搜索历史
        if (keyword != null) {
            SearchHistory searchHistory = new SearchHistory();
            Date date = new Date();
            searchHistory.setAddTime(date);
            searchHistory.setUpdateTime(date);
            searchHistory.setUserId(userId);
            searchHistory.setKeyword(keyword);
            mallMapper.insertSearchHistory(searchHistory);
        }
        return goodsListInfo;
    }


    @Override
    public Map selectBrandById(int id) {
        Brand brand = wxBrandMapper.selectBrandById(id);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("brand", brand);
        return resultMap;
    }

    @Override
    public Map selectTopicAll(BrandPageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<Topic> topics = wxBrandMapper.selectTopicAll();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("data", topics);
        resultMap.put("count", new PageInfo<>(topics).getTotal());
        return resultMap;
    }

    @Override
    public Map selectTopicById(int id) {
        Topic topic = wxBrandMapper.selectTopicById(id);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("topic", topic);
        resultMap.put("goods", topic.getGoods());
        return resultMap;
    }

    @Override
    public Map selectCommentsByValueId(BrandPageInfo pageInfo, int valueId) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<CommentLJQ> comments = wxBrandMapper.selectCommentsByValueId(valueId);
        PageInfo<CommentLJQ> commentsPageInfo = new PageInfo<>(comments);
        long total = commentsPageInfo.getTotal();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("data", comments);
        resultMap.put("count", total);
        resultMap.put("currentPage", pageInfo.getPage());
        return resultMap;
    }

    @Override
    public Comment commentPost(Comment comment, HttpServletRequest request) {
        comment.setAddTime(new Date());
        comment.setUpdateTime(new Date());
        /*待修改*/
        comment.setUserId(1);
        wxBrandMapper.insertComment(comment);
        return comment;
    }

    @Override
    public List<Topic> selectTopicRelated(int id) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        long total = new PageInfo<>(wxBrandMapper.selectTopicRelated(id)).getTotal();
        final int size = 4;
        PageHelper.startPage((int) Math.ceil(Math.random() * Math.ceil(total / size)), size);
        List<Topic> topics = wxBrandMapper.selectTopicRelated(id);
        return topics;
    }

    @Override
    public void searchClearhistory(int userId) {
        mallMapper.deleteSearchHistory(userId);
    }

    @Override
    public GoodsCategoryInfo goodsCategory(Integer id) {
        int pid = mallMapper.selectCategoryPidById(id);
        Category parent = null;
        List<Category> brothers = null;
        Category current = null;
        if (pid == 0) {
            brothers = mallMapper.selectCategoryChildren(id);
            parent = mallMapper.selectCategoryById(id);
            current = brothers.get(0);
        } else {
            parent = mallMapper.selectCategoryById(pid);
            brothers = mallMapper.selectCategoryChildren(pid);
            current = mallMapper.selectCategoryById(id);
        }
        GoodsCategoryInfo categoryInfo = new GoodsCategoryInfo();
        categoryInfo.setBrotherCategory(brothers);
        categoryInfo.setCurrentCategory(current);
        categoryInfo.setParentCategory(parent);
        return categoryInfo;
    }

    @Override
    public CouponListInfo couponList(FromPageInfo fromPageInfo) {
        PageHelper.startPage(fromPageInfo.getPage(), fromPageInfo.getLimit());
        List<Coupon> allCoupons = generalizeMapper.getAllCoupons(null, null, null);
        ListBean listBean = new BeansManager().toListBean(allCoupons);
        long total = listBean.getTotal();
        CouponListInfo couponListInfo = new CouponListInfo();
        couponListInfo.setCount((int) total);
        couponListInfo.setData(allCoupons);
        return couponListInfo;
    }

    @Override
    public String couponReceive(Integer userId, Integer couponId) {
        Coupon coupon = generalizeMapper.queryCouponById(couponId);
        if (coupon == null) {
            return "该优惠券不存在";
        }
        if (coupon.getTotal() <= 0) {
            return "优惠券已领完";
        }
        int number = generalizeMapper.selectUserCouponIsOwn(userId,couponId);
        if (number != 0) {
            return "优惠券已经领取过";
        }
        generalizeMapper.insertUserCoupon(userId,couponId,new Date());
        coupon.setTotal(coupon.getTotal() - 1);
        generalizeMapper.updateCoupon(coupon);
        return null;
    }

    @Override
    public GrouponPageInfo grouponList(FromPageInfo fromPageInfo) {
        PageHelper.startPage(fromPageInfo.getPage(),fromPageInfo.getLimit());
        List<GrouponInfo> grouponInfos = generalizeMapper.getGrouponInfo();
        ListBean listBean = new BeansManager().toListBean(grouponInfos);
        long total = listBean.getTotal();
        GrouponPageInfo grouponPageInfo = new GrouponPageInfo();
        grouponPageInfo.setCount((int) total);
        grouponPageInfo.setData(grouponInfos);
        return grouponPageInfo;
    }

}
