package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;

import java.util.List;
import java.util.Map;

public interface WxPersonalService {
    Map personalIndex();

    List<Address> addressList();

    AddressRegion addressDetail(int id);
}
