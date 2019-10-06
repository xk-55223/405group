package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxBrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public WxIndexInfo homeIndex() {
        List<Category> categories = mallMapper.selectCategorys();
        List<Brand> brands = mallMapper.selectBrands(null);
        List<Coupon> allCoupons = generalizeMapper.getAllCoupons(null, null, null);
        List<Ad> allAds = generalizeMapper.getAllAds(null, null);
        List<Goods> hotGoods = goodsMapper.selectHotGoods(true);
        List<Goods> newGoods = goodsMapper.selectNewGoods(true);
        List<GrouponInfo> grouponInfos = generalizeMapper.getGrouponInfo();
        List<Category> floorGoodsList = mallMapper.selectCategorys();
        List<Topic> allTopic = generalizeMapper.getAllTopic(null, null);
        WxIndexInfo wxIndexInfo = new WxIndexInfo();
        wxIndexInfo.setHotGoods(hotGoods);
        wxIndexInfo.setNewGoods(newGoods);
        wxIndexInfo.setBanner(allAds);
        wxIndexInfo.setBrandList(brands);
        wxIndexInfo.setChannel(categories);
        wxIndexInfo.setCouponList(allCoupons);
        wxIndexInfo.setGrouponList(grouponInfos);
        wxIndexInfo.setFloorGoodsList(floorGoodsList);
        wxIndexInfo.setTopicList(allTopic);
        return wxIndexInfo;
    }

    @Override
    public GoodsCount goodsCount() {
        return goodsMapper.selectGoodsCount();
    }

    @Override
<<<<<<< HEAD
    public Map selectBrandAll(BrandPageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<Brand> brands = wxBrandMapper.selectBrandAll();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        long total = brandPageInfo.getTotal();
=======
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
    public GoodsListInfo goodsList(int userId, String keyword, FromPageInfo info, int categoryId) {
        GoodsListInfo goodsListInfo = new GoodsListInfo();
        PageHelper.startPage(info.getPage(),info.getLimit());
        List<Goods> goods = goodsMapper.selectGoodsByKeywordAndCategoryId(keyword,categoryId,info);
        List<Category> categories = goodsMapper.selectGoodsCategorys(keyword);
        BeansManager beansManager = new BeansManager();
        ListBean listBean = beansManager.toListBean(goods);
        int total = (int) listBean.getTotal();
        goodsListInfo.setCount(total);
        goodsListInfo.setFilterCategoryList(categories);
        goodsListInfo.setGoodsList(goods);
        // 添加搜索历史
        SearchHistory searchHistory = new SearchHistory();
        Date date = new Date();
        searchHistory.setAddTime(date);
        searchHistory.setUpdateTime(date);
        searchHistory.setUserId(userId);
        searchHistory.setKeyword(keyword);
        mallMapper.insertSearchHistory(searchHistory);
        return goodsListInfo;
    }

    public Map selectBrandAll(FromPageInfo fromPageInfo) {
        PageHelper.startPage(fromPageInfo.getPage(), fromPageInfo.getLimit());
        List<Brand> brands = wxBrandMapper.selectBrandAll(fromPageInfo);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        long total = pageInfo.getTotal();
>>>>>>> d190f5689896654bb0635c3ff962b90982f8d109
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("totalPages", Math.ceil(total * 1.0 / pageInfo.getSize()));
        resultMap.put("brandList", brands);
        return resultMap;
    }

    @Override
<<<<<<< HEAD
    public Map selectBrandById(int id) {
        Brand brand = wxBrandMapper.selectBrandById(id);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("brand",brand);
        return resultMap;
    }

    @Override
    public Map selectGoodsAll(BrandPageInfo pageInfo, int brandId) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<Goods> goods = wxBrandMapper.selectGoodsByBrandId(brandId);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("goodsList",goods);
        return resultMap;
=======
    public void searchClearhistory(int userId) {
        mallMapper.deleteSearchHistory(userId);
>>>>>>> d190f5689896654bb0635c3ff962b90982f8d109
    }

}
