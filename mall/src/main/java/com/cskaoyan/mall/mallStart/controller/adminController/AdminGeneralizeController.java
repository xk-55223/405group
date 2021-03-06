package com.cskaoyan.mall.mallStart.controller.adminController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.service.adminService.AdminGeneralizeService;
import com.cskaoyan.mall.mallStart.tool.StringIsEmpty;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminGeneralizeController {
    @Autowired
    AdminGeneralizeService service;

    //为分页先进行导包并配置公共的配置文件
    //列出所有广告，封装类为List<Ad>,查询表为cskaoyan_mall_ad,
    //为分页新建类AdListBean接收service层数据，详见service层。
    //mapper层不需处理分页
    @RequestMapping("admin/ad/list")
    @RequiresPermissions("admin:ad:list")
    public BaseRespVo listAd(int page,int limit,String name,String content){
        AdListBean allAds = service.getAllAds(page, limit,name,content);
        BaseRespVo ok = BaseRespVo.ok(allAds);
        return ok;
    }

// 新增广告由两个接口完成，图片上传再完善，先完成后半部分
    @RequestMapping("admin/ad/create")
    @RequiresPermissions("admin:ad:create")
    public BaseRespVo createAd(@RequestBody Ad ad){
        if(StringIsEmpty.stringIsEmpty(ad.getContent())){
            return BaseRespVo.fail("兄弟，请输入广告内容");
        }
        if(StringIsEmpty.stringIsEmpty(ad.getName())){
            return BaseRespVo.fail("兄弟，请输入广告标题");
        }
        Ad ad1 = service.insertAd(ad);
        BaseRespVo ok = BaseRespVo.ok(ad1);
        return ok;
    }

//更新广告主要是对六个参数和更新时间进行更新
    //service层调用两次mapper方法，一次更新，一次查询
    @RequestMapping("admin/ad/update")
    @RequiresPermissions("admin:ad:update")
    public BaseRespVo updateAd(@RequestBody Ad ad) {
        if(StringIsEmpty.stringIsEmpty(ad.getContent())){
            return BaseRespVo.fail("兄弟，请输入广告内容");
        }
        if(StringIsEmpty.stringIsEmpty(ad.getName())){
            return BaseRespVo.fail("兄弟，请输入广告标题");
        }
        Ad ad1 = service.updateAd(ad);
        BaseRespVo ok = BaseRespVo.ok(ad1);
        return ok;
    }
//删除广告,基本操作，mapper直接注解
    @RequestMapping("admin/ad/delete")
    @RequiresPermissions("admin:ad:delete")
    public BaseRespVo deleteAd(@RequestBody Ad ad) {
        service.deleteAd(ad);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }

    //优惠券查找和列表，和广告处理方法一样
    @RequestMapping("admin/coupon/list")
    @RequiresPermissions("admin:coupon:list")
    public BaseRespVo listCoupon(int page,int limit,Integer type,Integer status,String name){
        CouponBeanList list =  service.listCoupon(page,limit,type,status,name);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    //优惠券添加,goodsValue的接收有问题，先搁置,
    // 有效期无法进行解析（无法将字符串解析为date类型）
    @RequestMapping("admin/coupon/create")
    @RequiresPermissions("admin:coupon:create")
    public BaseRespVo addCoupon(@RequestBody Coupon coupon){
        if(StringIsEmpty.stringIsEmpty(coupon.getName())){
            return BaseRespVo.fail("兄弟，请输入优惠券名称");
        }
        if(coupon.getDiscount().signum()== -1|coupon.getDays()<0|coupon.getMin().signum()<0 |
        coupon.getLimit()<0|coupon.getTotal()<0){
            return BaseRespVo.fail("兄弟，请不要输入负数");
        }

       Coupon coupon1= service.addCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon1);
        return ok;
    }
    //点击详情有两个请求，一个是对user的请求对user进行list(查找)，
    // 另一个是从数据库中返回coupon的数据。
    @RequestMapping("admin/coupon/listuser")
    @RequiresPermissions("admin:coupon:listuser")
    public BaseRespVo listCouponUser(int page,int limit,int couponId,Integer userId,Integer status){
        CouponUserBeanList list =  service.listCouponUser(page,limit,couponId,userId,status);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    @RequestMapping("admin/coupon/read")
    @RequiresPermissions("admin:coupon:read")
    public BaseRespVo readCoupon(int id){
        Coupon coupon = service.queryCouponById(id);
        BaseRespVo ok = BaseRespVo.ok(coupon);
        return ok;
    }
    //删除操作需要接收json格式的coupon,先搁置
    @RequestMapping("admin/coupon/delete")
    @RequiresPermissions("admin:coupon:delete")
    public BaseRespVo deleteCoupon(@RequestBody Coupon coupon){
        service.deleteCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }

    //修改coupon
    @RequestMapping("admin/coupon/update")
    @RequiresPermissions("admin:coupon:update")
    public BaseRespVo updateCoupon(@RequestBody Coupon coupon){
        if(StringIsEmpty.stringIsEmpty(coupon.getName())){
            return BaseRespVo.fail("兄弟，请输入优惠券名称");
        }
        if(coupon.getDiscount().signum()== -1|coupon.getDays()<0|coupon.getMin().signum()<0 |
                coupon.getLimit()<0|coupon.getTotal()<0){
            return BaseRespVo.fail("兄弟，请不要输入负数");
        }
        Coupon coupon1 = service.updateCoupon(coupon);
        BaseRespVo ok = BaseRespVo.ok(coupon1);
        return ok;
    }

    // 列出所有专题
    @RequestMapping("admin/topic/list")
    @RequiresPermissions("admin:topic:list")
    public BaseRespVo listTopic(int page,int limit,String title,String subtitle){
       GeneralizeTopicBeanList list = service.getAllTopic(page,limit,title,subtitle);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }

    //删除专题
    @RequestMapping("admin/topic/delete")
    @RequiresPermissions("admin:topic:delete")
    public BaseRespVo deleteTopic(@RequestBody Topic topic){
        service.deleteTopic(topic);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }
    //新建专题
    @RequestMapping("admin/topic/create")
    @RequiresPermissions("admin:topic:create")
    public BaseRespVo insertTopic(@RequestBody Topic topic){
        if(StringIsEmpty.stringIsEmpty(topic.getTitle())){
            return BaseRespVo.fail("兄弟，请输入正确标题");
        }
        if(StringIsEmpty.stringIsEmpty(topic.getSubtitle())){
            return BaseRespVo.fail("兄弟，请输入正确子标题");
        }
        Topic topic1 =  service.insertTopic(topic);
        BaseRespVo ok = BaseRespVo.ok(topic1);
        return ok;
    }

    //修改topic
    @RequestMapping("admin/topic/update")
    @RequiresPermissions("admin:topic:update")
    public BaseRespVo updateTopic(@RequestBody Topic topic){
        if(StringIsEmpty.stringIsEmpty(topic.getTitle())){
            return BaseRespVo.fail("兄弟，请输入正确标题");
        }
        if(StringIsEmpty.stringIsEmpty(topic.getSubtitle())){
            return BaseRespVo.fail("兄弟，请输入正确子标题");
        }
        Topic topic1 =  service.updateTopic(topic);
        BaseRespVo ok = BaseRespVo.ok(topic1);
        return ok;
    }

    //团购的查询 数据库表为groupon_rules
    @RequestMapping("admin/groupon/list")
    @RequiresPermissions("admin:groupon:list")
    public BaseRespVo getAllGrouponRules(int page,int limit,Integer goodsId){
        ListBean list = service.getAllGrouponRules(page,limit,goodsId);
        BaseRespVo ok = BaseRespVo.ok(list);
        return ok;
    }
    //团购规则增加，需要通过商品id去查询商品的部分参数并填入groupRules表中
    @RequestMapping("admin/groupon/create")
    @RequiresPermissions("admin:groupon:create")
    public BaseRespVo insertGrouponRules(@RequestBody GrouponRules grouponRules){
        Boolean flag = service.isGoodsExist(grouponRules.getGoodsId());
        if(!flag){
            return BaseRespVo.fail("不存在的，这个商品");
        }
        if(grouponRules.getDiscountMember()==null|grouponRules.getExpireTime()==null|grouponRules.getDiscount()==null){
            return BaseRespVo.fail("兄弟，请输入完整参数");
        }
        if(grouponRules.getDiscount().signum()<0|grouponRules.getDiscountMember()<0){
            return BaseRespVo.fail("兄弟，请不要输入负数");
        }

        GrouponRules grouponRules1 =service.insertGrouponRules(grouponRules);
        BaseRespVo ok = BaseRespVo.ok(grouponRules1);
        return ok;
    }
    //团购规则更改，若是尼玛更改商品id就他妈的要重新查询goods并重新赋值
    @RequestMapping("admin/groupon/update")
    @RequiresPermissions("admin:groupon:update")
    public BaseRespVo updateGrouponRules(@RequestBody GrouponRules grouponRules){
        Boolean flag = service.isGoodsExist(grouponRules.getGoodsId());
        if(!flag){
            return BaseRespVo.fail("不存在的，这个商品");
        }
        if(grouponRules.getDiscountMember()==null|grouponRules.getExpireTime()==null|grouponRules.getDiscount()==null){
            return BaseRespVo.fail("兄弟，请输入完整参数");
        }
        if(grouponRules.getDiscount().signum()<0|grouponRules.getDiscountMember()<0){
            return BaseRespVo.fail("兄弟，请不要输入负数");
        }

        service.updateGrouponRules(grouponRules);
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }
    //删除团购规则
    @RequestMapping("admin/groupon/delete")
    @RequiresPermissions("admin:groupon:delete")
    public BaseRespVo deleteGrouponRules(@RequestBody GrouponRules grouponRules){
        service.deleteGrouponRules(grouponRules.getId());
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }

    //团购活动添加，新建GrouponBean类，封装goods、groupon、grouponRules和一个string数组
    //对GrouponBean进行分页和查询。
    @RequestMapping("admin/groupon/listRecord")
    @RequiresPermissions("admin:groupon:read")
    public BaseRespVo listGroupon(int page,int limit,Integer goodsId){
       ListBean listBean = service.listGroupon(page,limit,goodsId);
        BaseRespVo ok = BaseRespVo.ok(listBean);
        return ok;
    }
}
