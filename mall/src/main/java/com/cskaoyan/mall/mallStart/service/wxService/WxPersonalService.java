package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.CreateGroupon;
import com.cskaoyan.mall.mallStart.bean.ListBean;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.bean.*;

import java.io.Serializable;


import java.util.List;
import java.util.Map;

public interface WxPersonalService {
    /*Map personalIndex();*/

    Map couponMylist(BrandPageInfo pageInfo, Integer status, Integer userId);

    Map collectList(BrandPageInfo pageInfo, Integer type, Integer userId);

    Map personalIndex();

    Map selectCreateGroupons(int userId);

    Map<String, Object> selectJoinedGroupons(int userId);

    List<Address> addressList(Integer userId);

    UserLoginInfo selectUserMessage(User user, Serializable token);

    int selectUserIdByUserName(String username);

    WxIndexInfo homeIndex();

    AddressRegion addressDetail(int id);

    Map footprintList(int page, int size, Serializable id);

    public boolean sendMessage(String mobile, String code);

    void addressSave(AddressRegion addressRegion, Integer userId);

    void addressDelete(Integer id);

    List<Region> selectRegionByPid(int pid);

    int feedbackSubmit(Feedback feedback);

    void deleteOrder(int id);

    GrouponDetail grouponDetail(int grouponId);

    boolean register(String mobile, String username, String password);

    void resetUser(String mobile, String password);

    Map<String, Object> orderDetail(int orderId);

}
