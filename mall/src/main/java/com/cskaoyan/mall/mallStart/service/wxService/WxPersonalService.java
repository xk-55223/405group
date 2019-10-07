package com.cskaoyan.mall.mallStart.service.wxService;

import com.cskaoyan.mall.mallStart.bean.BrandPageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface WxPersonalService {
    /*Map personalIndex();*/

    Map couponMylist(BrandPageInfo pageInfo, Integer status, Integer userId);
}
