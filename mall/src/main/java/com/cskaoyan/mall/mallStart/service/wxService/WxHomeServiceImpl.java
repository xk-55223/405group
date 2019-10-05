package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminConfigMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.tool.BeansManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxHomeServiceImpl implements WxHomeService {
    @Autowired
    AdminMallMapper mallMapper;

    @Autowired
    AdminGoodsMapper goodsMapper;

    @Autowired
    AdminGeneralizeMapper generalizeMapper;



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
    public SearchIndexInfo searchIndex() {
        List<Keyword> hotKeywords = mallMapper.selectHotKeywords(true);
        Keyword defaultKeyword = mallMapper.selectDefaultKeyword();
        List<Keyword> historyKeywords = mallMapper.selectHistoryKeywords();
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
    public GoodsListInfo goodsList(String keyword, FromPageInfo info, int categoryId) {
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
        return goodsListInfo;
    }
}
