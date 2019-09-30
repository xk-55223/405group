package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.controller.FirstPageController;
import com.cskaoyan.mall.mallStart.mapper.FirstPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstPageService {
    @Autowired
    FirstPageMapper firstPageMapper;

    public DashBoard getDashBorad(){
        DashBoard dashBoard = new DashBoard();
        dashBoard.setGoodsTotal(firstPageMapper.getGoodsTotal());
        dashBoard.setOrderTotal(firstPageMapper.getOrderTotal());
        dashBoard.setUserTotal(firstPageMapper.getUserTotal());
        dashBoard.setProductTotal(firstPageMapper.getProductTotal());
        return dashBoard;
    }

}
