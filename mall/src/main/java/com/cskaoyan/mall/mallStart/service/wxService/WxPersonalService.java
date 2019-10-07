package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.CreateGroupon;
import com.cskaoyan.mall.mallStart.bean.ListBean;

import java.util.Map;

public interface WxPersonalService {
    Map personalIndex();
    Map selectCreateGroupons(int userId);

    Map<String, Object> selectJoinedGroupons(int userId);
}
