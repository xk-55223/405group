package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxBrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map selectBrandAll(FromPageInfo fromPageInfo) {
        PageHelper.startPage(fromPageInfo.getPage(), fromPageInfo.getLimit());
        List<Brand> brands = wxBrandMapper.selectBrandAll(fromPageInfo);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        long total = pageInfo.getTotal();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("totalPages", total);
        resultMap.put("brandList", brands);
        return resultMap;
    }

}
