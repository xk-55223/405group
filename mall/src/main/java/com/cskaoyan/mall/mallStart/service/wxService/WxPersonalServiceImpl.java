package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.MyCoupon;
import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.config.AliyunConfig;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.cskaoyan.mall.mallStart.tool.OrderStatus;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxBrandMapper;
import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.github.pagehelper.PageHelper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;

import java.util.Date;
import java.io.Serializable;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.*;
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
    AdminGeneralizeMapper generalizeMapper;
    @Autowired
    AdminGoodsMapper goodsMapper;
    @Autowired
    AdminUserMapper userMapper;
    @Autowired
    AdminMallMapper mallMapper;

    @Autowired
    WxBrandMapper wxBrandMapper;
    @Autowired
    AliyunConfig aliyunConfig;

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
            switch (status / 100) {
                case 1:
                    unrecvNo++;
                    break;
                case 2:
                    uncommentNo++;
                    break;
                case 3:
                    unpaidNo++;
                    break;
                case 4:
                    unshipNo++;
            }
        }
        order.put("unrecv", unrecvNo);
        order.put("uncomment", uncommentNo);
        order.put("unpaid", unpaidNo);
        order.put("unship", unshipNo);
        orderInfo.put("order", order);
        return orderInfo;
    }

    @Override
    public Map selectCreateGroupons(int userId) {
        Map<Object, Object> map = new HashMap<>();
        int count = generalizeMapper.countGrouponByCreatorId(userId);
        if(count == 0){
            List<Object> data = new ArrayList<>();
            CreateGroupon createGroupon = new CreateGroupon();
            data.add(createGroupon);
            map.put("count",0);
            map.put("data",data);
            return map;
        }
        map.put("count",count);
        //根据userId查找groupons，遍历数组，逐个封装为CreateGroupon,最后返回List
        List<CreateGroupon> data = new ArrayList<>();
        List<Groupon> groupons = generalizeMapper.queryAllGrouponsByCreator(userId);
        for(Groupon groupon:groupons){
            CreateGroupon createGroupon = new CreateGroupon();
            String creator = userMapper.getUserNicknameById(userId);
            GrouponRules rules = generalizeMapper.getGrouponRulesById(groupon.getRulesId());
            Order order = mallMapper.selectOrderById(groupon.getOrderId());
            BigDecimal actualPrice = order.getActualPrice();
            int orderId = order.getId();
            String orderSn = order.getOrderSn();
            Short orderStatus = order.getOrderStatus();
            String orderStatusText = OrderStatus.getString(orderStatus);
            int joinerCount = generalizeMapper.selectUsersByGrouponRulesId(groupon.getRulesId());
            List<OrderGoods> goodsList = mallMapper.selectOrderGoods(order.getId());
            createGroupon.setActualPrice(actualPrice);
            createGroupon.setCreator(creator);
            createGroupon.setGoodsList(goodsList);
            createGroupon.setGroupon(groupon);
            createGroupon.setHandleOption(new HandleOption());
            createGroupon.setCreator(true);
            createGroupon.setJoinerCount(joinerCount);
            createGroupon.setOrderId(orderId);
            createGroupon.setOrderSn(orderSn);
            createGroupon.setOrderStatusText(orderStatusText);
            createGroupon.setRules(rules);
            createGroupon.setId(groupon.getId());

            data.add(createGroupon);
        }
        map.put("data",data);
        return map;
    }

    @Override
    public Map<String, Object> selectJoinedGroupons(int userId) {
        HashMap<String, Object> map = new HashMap<>();
        int count = generalizeMapper.countGrouponByUserId(userId);
        if (count == 0) {
            List<Object> data = new ArrayList<>();
            CreateGroupon createGroupon = new CreateGroupon();
            data.add(createGroupon);
            map.put("count", 0);
            map.put("data", data);
            return map;
        }
        List<CreateGroupon> data = new ArrayList<>();
        map.put("count", count);
        List<Groupon> groupons = generalizeMapper.queryAllGrouponsByUserId(userId);
        for (Groupon groupon : groupons) {
            CreateGroupon createGroupon = new CreateGroupon();
            int i = userMapper.getOrderCreatorByUserId(userId, groupon.getRulesId());
            String creator = userMapper.getUserNicknameById(i);
            GrouponRules rules = generalizeMapper.getGrouponRulesById(groupon.getRulesId());
            Order order = mallMapper.selectOrderById(groupon.getOrderId());
            BigDecimal actualPrice = order.getActualPrice();
            int orderId = order.getId();
            String orderSn = order.getOrderSn();
            Short orderStatus = order.getOrderStatus();
            String orderStatusText = OrderStatus.getString(orderStatus);
            int joinerCount = generalizeMapper.selectUsersByGrouponRulesId(groupon.getRulesId());
            List<OrderGoods> goodsList = mallMapper.selectOrderGoods(order.getId());
            createGroupon.setActualPrice(actualPrice);
            createGroupon.setCreator(creator);
            createGroupon.setGoodsList(goodsList);
            createGroupon.setGroupon(groupon);
            createGroupon.setHandleOption(new HandleOption());
            createGroupon.setCreator(false);
            createGroupon.setJoinerCount(joinerCount);
            createGroupon.setOrderId(orderId);
            createGroupon.setOrderSn(orderSn);
            createGroupon.setOrderStatusText(orderStatusText);
            createGroupon.setRules(rules);
            createGroupon.setId(groupon.getId());
            data.add(createGroupon);
        }
        map.put("count", count);
        map.put("data", data);
        return map;
    }
    @Override
    public boolean sendMessage(String mobile, String code) {
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        String regionId = aliyunConfig.getSmsConfig().getRegionId();
        String templateCode = aliyunConfig.getSmsConfig().getTemplateCode();
        String signName = aliyunConfig.getSmsConfig().getSignName();

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(response.getData(), Map.class);
            String message = (String) map.get("Message");
            return "OK".equals(message);
        } catch (ServerException e) {
            return false;
            //e.printStackTrace();
        } catch (ClientException e) {
            return false;
            //e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Map couponMylist(BrandPageInfo pageInfo, Integer status, Integer userId) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<MyCoupon> myCoupons = wxPersonalMapper.selectCouponByUserId(status, userId);
        PageInfo<MyCoupon> myCouponPageInfo = new PageInfo<>(myCoupons);
        long total = myCouponPageInfo.getTotal();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("data", myCoupons);
        resultMap.put("count", total);
        return resultMap;
    }

    @Override
    public Map collectList(BrandPageInfo pageInfo, Integer type, Integer userId) {
        PageHelper.startPage(pageInfo.getPage(), pageInfo.getSize());
        List<MyCollect> collects = wxPersonalMapper.selectCollectsByUserId(type, userId);
        PageInfo<MyCollect> collectPageInfo = new PageInfo<>(collects);
        long total = collectPageInfo.getTotal();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("collectList", collects);
        resultMap.put("totalPages", total);
        return resultMap;
    }


    @Override
    public List<Address> addressList(Integer userId) {
        List<Address> addresses = wxPersonalMapper.selectAddresses(userId);
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

    @Override
    public Map footprintList(int page, int size, Serializable id) {
        Map result = new HashMap();
        Map goodDetail = new HashMap();
        List footprintList = new ArrayList();
        PageHelper.startPage(page, size);
        List<Footprint> footprints = wxPersonalMapper.selectfootprintDetail(id);
        int totalpages = wxPersonalMapper.getTotalNumById(id);
        for (Footprint footprint : footprints) {
            goodDetail.put("addTime", footprint.getAddTime());
            goodDetail.put("id", footprint.getId());
            goodDetail.put("goodsId", footprint.getGoodsId());
            Goods goods = goodsMapper.listGoodsById(footprint.getGoodsId());
            if (goods != null) {
                goodDetail.put("brief", goods.getBrief());
                goodDetail.put("name", goods.getName());
                goodDetail.put("retailPrice", goods.getRetailPrice());
                goodDetail.put("picUrl", goods.getPicUrl());
            }
            footprintList.add(goodDetail);
        }
        result.put("footprintList", footprintList);
        result.put("totalPages", totalpages);
        return result;
    }

    public void addressSave(AddressRegion addressRegion,Integer userId) {
        Date date = new Date();
        addressRegion.setUpdateTime(date);
        if (addressRegion.getId() != 0) {
            wxPersonalMapper.updateAddress(addressRegion);
        } else {
            addressRegion.setAddTime(date);
            wxPersonalMapper.insertAddress(addressRegion, userId);
        }
    }

    @Override
    public void addressDelete(Integer id) {
        wxPersonalMapper.addressDelete(id);
    }

    @Override
    public List<Region> selectRegionByPid(int pid) {
        List<Region> regions = wxPersonalMapper.selectRegionByPid(pid);
        return regions;
    }

    @Override
    public int feedbackSubmit(Feedback feedback) {
        return wxPersonalMapper.insertFeedback(feedback);
    }
    public void deleteOrder(int id) {
        mallMapper.deleteOrder(id);
    }

    public GrouponDetail grouponDetail(int grouponId) {
        GrouponDetail grouponDetail = new GrouponDetail();
        int creatorId = userMapper.getOrderCreatorById(grouponId);
        String userNicknameById = userMapper.getUserNicknameById(creatorId);
        User creator = new User();
        creator.setNickname(userNicknameById);
        Groupon groupon = generalizeMapper.getGrouponById(grouponId);
        Integer rulesId = groupon.getRulesId();
        int[] i = generalizeMapper.getUserIdByRulesId(rulesId);
        List<User> joiners = new ArrayList<>();
        for (int id : i) {
            User user1 = new User();
            String userNicknameById1 = userMapper.getUserNicknameById(id);
            user1.setNickname(userNicknameById1);
            joiners.add(user1);
        }
        Order orderInfo = mallMapper.selectOrderById(grouponId);
        List<OrderGoods> orderGoods = mallMapper.selectOrderGoods(orderInfo.getId());
        GrouponRules rules = generalizeMapper.getGrouponRulesById(groupon.getRulesId());
        grouponDetail.setCreator(creator);
        grouponDetail.setGroupon(groupon);
        grouponDetail.setJoiners(joiners);
        grouponDetail.setLinkGrouponId(grouponId);
        grouponDetail.setOrderGoods(orderGoods);
        grouponDetail.setOrderInfo(orderInfo);
        grouponDetail.setRules(rules);
        return grouponDetail;
    }

    @Override
    public boolean register(String mobile, String username, String password) {
        User user = new User();
        Date date = new Date();
        user.setAddTime(date);
        user.setAvatar("");
        user.setLastLoginTime(date);
        user.setUpdateTime(date);
        user.setGender((byte) 1);
        user.setPassword(password);
        user.setUsername(username);
        user.setNickname(username);
        user.setMobile(mobile);
        user.setBirthday(date);
        int flag = userMapper.insertUser(user);
        if (flag == 0) return  false;
        return true;
    }

    @Override
    public void resetUser(String mobile, String password) {
        userMapper.updateUserPasswordByMoblie(mobile,password);
    }
}
