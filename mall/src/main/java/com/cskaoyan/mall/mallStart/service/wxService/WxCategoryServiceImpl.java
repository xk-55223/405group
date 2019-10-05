package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxCategoryServiceImpl implements WxCategoryService {
    @Autowired
    AdminFirstPageMapper firstPageMapper;
    @Autowired
    AdminGoodsMapper goodsMapper;
    @Autowired
    AdminMallMapper mallMapper;
    @Autowired
    AdminGeneralizeMapper generalizeMapper;
    @Autowired
    AdminUserMapper userMapper;
    @Override
    public int countGoods() {
        int goodsTotal = firstPageMapper.getGoodsTotal();
        return goodsTotal;
    }

    @Override
    public Map<String, Object> currentCatalog(int id) {
        HashMap<String, Object> map = new HashMap<>();
        Category currentCategory = goodsMapper.goodCategory(id);
        List<Category> currentSubCategory = new ArrayList<>();
        currentSubCategory = mallMapper.selectCategoryChildren(id);
        map.put("currentCategory",currentCategory);
        map.put("currentSubCategory",currentSubCategory);
        return map;
    }

    @Override
    public List<Category> currentCategoryList() {
        List<Category> categories = mallMapper.selectCategorys();
        return categories;
    }

    @Override
    public WxGoodsDetail getWxGoodsDetail(int id,int userId) {
        WxGoodsDetail detail = new WxGoodsDetail();
        List<GoodsAttribute> goodsAttributes = goodsMapper.goodAttributes(id);
        Goods info = goodsMapper.listGoodsById(id);
        Brand brand = mallMapper.selectBrandById(info.getBrandId());
        List<GrouponRules> groupon = generalizeMapper.getGrouponRulesByGoodsId(id);
        List<Issue> issues = mallMapper.selectIssues(null);
        List<GoodsProduct> productList = goodsMapper.goodProducts(id);
        List<GoodsSpecification> goodsSpecifications = goodsMapper.goodSpecification(id);
        List<GoodsSpecificationBean> speccificationList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for(GoodsSpecification goodsSpecification:goodsSpecifications){
            String specification = goodsSpecification.getSpecification();
            if(!strings.contains(specification)){
                strings.add(specification);
            }
        }
        for(String name:strings) {
            GoodsSpecificationBean goodsSpecificationBean = new GoodsSpecificationBean();
            goodsSpecificationBean.setName(name);
            List<GoodsSpecification> goodsSpecifications1 = new ArrayList<>();
            for (GoodsSpecification goodsSpecification : goodsSpecifications) {
                if(name == goodsSpecification.getSpecification()){
                    goodsSpecifications1.add(goodsSpecification);
                }
            }
            goodsSpecificationBean.setValueList(goodsSpecifications1);
            speccificationList.add(goodsSpecificationBean);
        }
        if(userId!=-1){
            int i = userMapper.queryCollectType(userId, id);
            detail.setUserHasCollect(i);
        }
        detail.setAttribute(goodsAttributes);
        detail.setBrand(brand);
        detail.setGroupon(groupon);
        detail.setInfo(info);
        detail.setIssue(issues);
        detail.setProductList(productList);
        detail.setSpecificationLists(speccificationList);
        return detail;



    }


}
