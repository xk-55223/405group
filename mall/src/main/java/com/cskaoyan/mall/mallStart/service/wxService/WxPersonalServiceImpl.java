package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.MyCoupon;
import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxBrandMapper;
import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: silphon
 * * @create: 2019-10-06 20:16
 **/
@Service
public class WxPersonalServiceImpl implements WxPersonalService {
    @Autowired
    WxPersonalMapper wxPersonalMapper;
    @Autowired
    AdminUserMapper userMapper;

    @Autowired
    AdminMallMapper mallMapper;

    @Autowired
    AdminGoodsMapper goodsMapper;

    @Autowired
    AdminGeneralizeMapper generalizeMapper;

    @Autowired
    WxBrandMapper wxBrandMapper;

    @Override
    public UserLoginInfo selectUserMessage(User user, Serializable token) {
        WxUser userInfo = userMapper.selectUserInfoByUserNameAndPassword(user);
        LocalDateTime tokenExpire = LocalDateTime.now();
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserInfo(userInfo);
        userLoginInfo.setToken(token);
        userLoginInfo.setTokenExpire(tokenExpire);
        return userLoginInfo;
    }
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
    public int selectUserIdByUserName(String username) {
        return userMapper.selectUserIdByUserName(username);
    }

    @Override
    public Map personalIndex() {
        Map order = new HashMap();
        Map orderInfo = new HashMap();
        int unrecvNo = 0;
        int uncommentNo = 0;
        int unpaidNo = 0;
        int unshipNo = 0;
        int[] statuses = wxPersonalMapper.selectOrderStatusId();
        for (int status : statuses) {
            switch (status / 100){
                case 1: unrecvNo++;break;
                case 2: uncommentNo++;break;
                case 3: unpaidNo++;break;
                case 4: unshipNo++;
            }
        }
        order.put("unrecv",unrecvNo);
        order.put("uncomment",uncommentNo);
        order.put("unpaid",unpaidNo);
        order.put("unship",unshipNo);
        orderInfo.put("order",order);
        return orderInfo;
    }

    @Override
    public Map couponMylist(BrandPageInfo pageInfo, Integer status, Integer userId) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<MyCoupon> myCoupons = wxPersonalMapper.selectCouponByUserId(status, userId);
        PageInfo<MyCoupon> myCouponPageInfo = new PageInfo<>(myCoupons);
        long total = myCouponPageInfo.getTotal();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("data",myCoupons);
        resultMap.put("count",total);
        return resultMap;
    }


    @Override
    public List<Address> addressList() {
        List<Address> addresses = wxPersonalMapper.selectAddresses();
        return addresses;
    }

    @Override
    public AddressRegion addressDetail(int id) {
        AddressRegion addressRegion = wxPersonalMapper.addressDetail(id);
        addressRegion.setProvinceName(wxPersonalMapper.selectProvinceById(addressRegion.getProvinceId()));
        addressRegion.setCityName(wxPersonalMapper.selectCityById(addressRegion.getCityId()));
        addressRegion.setAreaName(wxPersonalMapper.selectAreaById(addressRegion.getAreaId()));
        return addressRegion;
    }
}
