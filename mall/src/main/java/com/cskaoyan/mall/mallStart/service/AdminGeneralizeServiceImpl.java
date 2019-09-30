package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.Ad;
import com.cskaoyan.mall.mallStart.bean.AdListBean;
import com.cskaoyan.mall.mallStart.mapper.AdminGeneralizeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminGeneralizeServiceImpl implements AdminGeneralizeService {
    @Autowired
    AdminGeneralizeMapper mapper;

    @Override
    public AdListBean getAllAds(int page, int limit,String name,String content) {
        PageHelper.startPage(page,limit);
        List<Ad> allAds = mapper.getAllAds(name,content);
        PageInfo<Ad> adPageInfo = new PageInfo<>(allAds);
        long total = adPageInfo.getTotal();
        AdListBean adListBean = new AdListBean();
        adListBean.setItems(allAds);
        adListBean.setTotal(total);
        return adListBean;
    }

    @Override
    public Ad insertAd(Ad ad) {
        int i = mapper.insertAd(ad);
        Ad ad1 = mapper.queryAdById(i);
        return ad1;
    }

    @Override
    public Ad updateAd(Ad ad) {
        Integer id = ad.getId();
        mapper.updateAd(ad);
        Ad ad1 = mapper.queryAdById(id);
        return ad1;
    }


}

