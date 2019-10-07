package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.Address;
import com.cskaoyan.mall.mallStart.bean.AddressRegion;
import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
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
    public void addressSave(AddressRegion addressRegion,Integer userId) {
        Date date = new Date();
        addressRegion.setUpdateTime(date);
        if(addressRegion.getId()!=0) {
            wxPersonalMapper.updateAddress(addressRegion);
        }else {
            addressRegion.setAddTime(date);
            wxPersonalMapper.insertAddress(addressRegion,userId);
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
}
