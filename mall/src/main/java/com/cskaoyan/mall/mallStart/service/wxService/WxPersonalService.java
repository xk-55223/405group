package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Region;

import java.util.List;
import java.util.Map;

public interface WxPersonalService {
    Map personalIndex();

    List<Address> addressList(Integer userId);

    AddressRegion addressDetail(int id);

    void addressSave(AddressRegion addressRegion,Integer userId);

    void addressDelete(Integer id);

    List<Region> selectRegionByPid(int pid);
}
