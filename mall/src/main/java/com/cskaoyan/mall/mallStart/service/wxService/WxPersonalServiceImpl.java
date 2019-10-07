package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGeneralizeMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminGoodsMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminUserMapper;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.cskaoyan.mall.mallStart.tool.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
            switch (status){
                case 101: unrecvNo++;break;
                case 102: uncommentNo++;break;
                case 103: unpaidNo++;break;
                case 104: unshipNo++;
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
            data.add(createGroupon);
        }
        map.put("data",data);
        return map;
    }

    @Override
    public Map<String, Object> selectJoinedGroupons(int userId) {
        HashMap<String,Object> map = new HashMap<>();
        int count = generalizeMapper.countGrouponByUserId(userId);
        if(count == 0){
            List<Object> data = new ArrayList<>();
            CreateGroupon createGroupon = new CreateGroupon();
            data.add(createGroupon);
            map.put("count",0);
            map.put("data",data);
            return map;
        }
        List<CreateGroupon> data = new ArrayList<>();
        map.put("count",count);
        List<Groupon> groupons = generalizeMapper.queryAllGrouponsByUserId(userId);
        for(Groupon groupon:groupons){
            CreateGroupon createGroupon = new CreateGroupon();
            int i = userMapper.getOrderCreatorByUserId(userId,groupon.getRulesId());
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
            data.add(createGroupon);
        }
        map.put("count",count);
        map.put("data",data);
        return map;
    }
}
