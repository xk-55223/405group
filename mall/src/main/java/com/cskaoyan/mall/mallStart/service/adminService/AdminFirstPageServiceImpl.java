package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.DashBoard;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminFirstPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminFirstPageServiceImpl implements AdminFirstPageService {

    @Autowired
    AdminFirstPageMapper firstPageMapper;

    @Override
    public DashBoard getDashBorad(){
        DashBoard dashBoard = new DashBoard();
        dashBoard.setGoodsTotal(firstPageMapper.getGoodsTotal());
        dashBoard.setOrderTotal(firstPageMapper.getOrderTotal());
        dashBoard.setUserTotal(firstPageMapper.getUserTotal());
        dashBoard.setProductTotal(firstPageMapper.getProductTotal());
        return dashBoard;
    }

    @Override
    public String selectAvatarByUserName(String username) {
        return firstPageMapper.selectAvatarByUserName(username);
    }

    @Override
    public List<String> selectRolesByUsername(String username) {
        return firstPageMapper.selectRolesByUsername(username);
    }

    @Override
    public List<String> selectPermissionByUserName(String username) {
        return firstPageMapper.selectPermissionByUserName(username);
    }
}
