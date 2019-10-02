package com.cskaoyan.mall.mallStart.controller;

import com.cskaoyan.mall.mallStart.bean.*;
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
//删除广告,基本操作，mapper直接注解
    @RequestMapping("admin/ad/delete")
    public BaseRespVo deleteAd(@RequestBody Ad ad) {
        service.deleteAd(ad);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }

    //优惠券查找和列表，和广告处理方法一样
    @RequestMapping("admin/coupon/list")
    public BaseRespVo listCoupon(int page,int limit,Integer type,Integer status,String name){
        CouponBeanList list =  service.listCoupon(page,limit,type,status,name);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    //优惠券添加,goodsValue的接收有问题，先搁置
    @RequestMapping("admin/coupon/create")
    public BaseRespVo addCoupon(@RequestBody Coupon coupon){
       Coupon coupon1= service.addCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon1);
        return ok;
    }
    //点击详情有两个请求，一个是对user的请求对user进行list(查找)，
    // 另一个是从数据库中返回coupon的数据。
    @RequestMapping("admin/coupon/listuser")
    public BaseRespVo listCouponUser(int page,int limit,int couponId,Integer userId,Integer status){
        CouponUserBeanList list =  service.listCouponUser(page,limit,couponId,userId,status);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    @RequestMapping("admin/coupon/read")
    public BaseRespVo readCoupon(int id){
        Coupon coupon = service.queryCouponById(id);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }
    //删除操作需要接收json格式的coupon,先搁置
    @RequestMapping("admin/coupon/delete")
    public BaseRespVo deleteCoupon(@RequestBody Coupon coupon){
        service.deleteCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }

    //修改coupon也需要json封装，搁置
    @RequestMapping("admin/coupon/update")
    public BaseRespVo updateCoupon(@RequestBody Coupon coupon){
        Coupon coupon1 = service.updateCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon1);
        return ok;
    }

    // 列出所有专题
    @RequestMapping("admin/topic/list")
    public BaseRespVo listTopic(int page,int limit,String title,String subtitle){
       GeneralizeTopicBeanList list = service.getAllTopic(page,limit,title,subtitle);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    //删除专题
    @RequestMapping("admin/topic/delete")
    public BaseRespVo deleteTopic(@RequestBody Topic topic){
        service.deleteTopic(topic);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }
    //新建专题
    @RequestMapping("admin/topic/create")
    public BaseRespVo insertTopic(@RequestBody Topic topic){
        Topic topic1 =  service.insertTopic(topic);
        BaseRespVo ok = BaseRespVo.ok(topic1);
        return ok;
    }

}
