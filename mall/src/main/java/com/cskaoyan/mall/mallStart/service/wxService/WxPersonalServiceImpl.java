package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;
import com.cskaoyan.mall.mallStart.bean.MyCoupon;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /*@Override
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
    }*/

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
}
