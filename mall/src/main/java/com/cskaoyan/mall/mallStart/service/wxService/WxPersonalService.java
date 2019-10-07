package com.cskaoyan.mall.mallStart.service.wxService;


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

    Map personalIndex();

    List<Address> addressList(Integer userId);

    UserLoginInfo selectUserMessage(User user, Serializable token);

    int selectUserIdByUserName(String username);

    WxIndexInfo homeIndex();


    AddressRegion addressDetail(int id);

    void addressSave(AddressRegion addressRegion,Integer userId);

    void addressDelete(Integer id);

    List<Region> selectRegionByPid(int pid);
}
