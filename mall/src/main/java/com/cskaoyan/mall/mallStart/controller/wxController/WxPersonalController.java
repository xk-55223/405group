package com.cskaoyan.mall.mallStart.controller.wxController;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import com.cskaoyan.mall.mallStart.bean.CreateGroupon;
import com.cskaoyan.mall.mallStart.bean.ListBean;
import com.cskaoyan.mall.mallStart.bean.WxIndexInfo;
import com.cskaoyan.mall.mallStart.mapper.wxMapper.WxPersonalMapper;
import com.cskaoyan.mall.mallStart.service.wxService.WxPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
   /*
    @RequestMapping("wx/user/index")
    public BaseRespVo personalIndex(){
        Map order = wxPersonalService.personalIndex();
        return BaseRespVo.ok(order);
    }
    */
   @RequestMapping("wx/groupon/my")
    public BaseRespVo myGroupon(int showType){
       int userId = 1;
       Map<String, Object> objectObjectHashMap = new HashMap<>();
       if(showType == 0){
           objectObjectHashMap =  wxPersonalService.selectCreateGroupons(userId);
            return BaseRespVo.ok(objectObjectHashMap);
       }
       objectObjectHashMap = wxPersonalService.selectJoinedGroupons(userId);
       return BaseRespVo.ok(objectObjectHashMap);
   }


}
