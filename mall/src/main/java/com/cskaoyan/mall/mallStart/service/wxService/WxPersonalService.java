package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.User;
import com.cskaoyan.mall.mallStart.bean.UserLoginInfo;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;

import java.io.Serializable;
import java.util.Map;

public interface WxPersonalService {
    Map personalIndex();

    UserLoginInfo selectUserMessage(User user, Serializable token);

    int selectUserIdByUserName(String username);

    WxIndexInfo homeIndex();
}
