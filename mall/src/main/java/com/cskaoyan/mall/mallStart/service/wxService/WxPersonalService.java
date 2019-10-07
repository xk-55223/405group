package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WxPersonalService {
    /*Map personalIndex();*/

    Map couponMylist(BrandPageInfo pageInfo, Integer status, Integer userId);

    Map personalIndex();

    UserLoginInfo selectUserMessage(User user, Serializable token);

    int selectUserIdByUserName(String username);

    WxIndexInfo homeIndex();

    List<Address> addressList();


    AddressRegion addressDetail(int id);
}
