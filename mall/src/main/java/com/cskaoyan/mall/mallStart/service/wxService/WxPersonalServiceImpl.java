package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
