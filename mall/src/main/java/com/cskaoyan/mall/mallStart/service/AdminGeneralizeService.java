package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Ad;
import com.cskaoyan.mall.mallStart.bean.AdListBean;

import java.util.List;

public interface AdminGeneralizeService {

    AdListBean getAllAds(int page, int limit,String name,String content);
    Ad insertAd(Ad ad);
    Ad updateAd(Ad ad);
}
