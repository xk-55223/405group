package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.Ad;
import com.cskaoyan.mall.mallStart.bean.AdListBean;
import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.Storage;
import com.cskaoyan.mall.mallStart.service.AdminGeneralizeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminGeneralizeController {
    @Autowired
    AdminGeneralizeService service;

    //为分页先进行导包并配置公共的配置文件
    //列出所有广告，封装类为List<Ad>,查询表为cskaoyan_mall_ad,
    //为分页新建类AdListBean接收service层数据，详见service层。
    //mapper层不需处理分页
    @RequestMapping("admin/ad/list")
    public BaseRespVo listAd(int page,int limit,String name,String content){
        AdListBean allAds = service.getAllAds(page, limit,name,content);
        BaseRespVo ok = BaseRespVo.ok(allAds);
        return ok;
    }
    //图片上传
   /* @RequestMapping("admin/storage/create")
    public BaseRespVo createAdImg(@RequestBody MultipartFile file){
        BaseRespVo ok = BaseRespVo.ok(storage);
        return ok;
    }*/

// 新增广告由两个接口完成，图片上传再完善，先完成后半部分
    @RequestMapping("admin/ad/create")
    public BaseRespVo createAd(@RequestBody Ad ad){
        Ad ad1 = service.insertAd(ad);
        BaseRespVo ok = BaseRespVo.ok(ad1);
        return ok;
    }

//更新广告主要是对六个参数和更新时间进行更新
    //service层调用两次mapper方法，一次更新，一次查询
    @RequestMapping("admin/ad/update")
    public BaseRespVo updateAd(@RequestBody Ad ad) {
        Ad ad1 = service.updateAd(ad);
        BaseRespVo ok = BaseRespVo.ok(ad1);
        return ok;
    }


}
