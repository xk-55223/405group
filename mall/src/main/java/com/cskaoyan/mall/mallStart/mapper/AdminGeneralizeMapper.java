package com.cskaoyan.mall.mallStart.mapper;

import com.cskaoyan.mall.mallStart.bean.Ad;
import com.cskaoyan.mall.mallStart.bean.Storage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminGeneralizeMapper {
    List<Ad> getAllAds(String name,String content);

    /*int insertAdImg();
    Storage queryAdimgById(int id);*/

    int insertAd(Ad ad);
    Ad queryAdById(int id);

    void updateAd(Ad ad);

}
