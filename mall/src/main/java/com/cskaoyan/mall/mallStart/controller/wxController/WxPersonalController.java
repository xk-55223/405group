package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.*;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.cskaoyan.mall.mallStart.service.wxService.WxPersonalService;
import com.cskaoyan.mall.mallStart.tool.UserTokenManager;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: mall
 * @description: 小程序端个人界面
 * @author: silphon
 * * @create: 2019-10-06 17:28
 **/
@RestController
public class WxPersonalController {

    @Autowired
    WxPersonalService wxPersonalService;
    Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");

//    @RequestMapping("wx/user/index")
//    public BaseRespVo personalIndex(){
//        Map order = wxPersonalService.personalIndex();
//        return BaseRespVo.ok(order);
//    }


    //-----------------地址管理------------------------
    @RequestMapping("wx/address/list")
    public BaseRespVo addressList(){
        List<Address> addresses = wxPersonalService.addressList(userId);
        BaseRespVo ok = BaseRespVo.ok(addresses);
        return ok;
    }

    @RequestMapping("wx/address/detail")
    public BaseRespVo addressDetail(int id){
        AddressRegion addressRegion = wxPersonalService.addressDetail(id);
        BaseRespVo ok = BaseRespVo.ok(addressRegion);
        return ok;
    }

    @RequestMapping("wx/address/save")
    public BaseRespVo addressSave(@RequestBody AddressRegion addressRegion){
        wxPersonalService.addressSave(addressRegion,userId);
        BaseRespVo ok = BaseRespVo.ok(addressRegion.getId());
        return ok;
    }

    @RequestMapping("wx/address/delete")
    public BaseRespVo addressDelete(@RequestBody Map<String,Integer> map){
        Integer id = map.get("id");
        wxPersonalService.addressDelete(id);
        BaseRespVo ok = BaseRespVo.ok("成功");
        return ok;
    }

    @RequestMapping("wx/region/list")
    public BaseRespVo regionList(int pid){
        List<Region> regions = wxPersonalService.selectRegionByPid(pid);
        BaseRespVo ok = BaseRespVo.ok(regions);
        return ok;
    }
}
