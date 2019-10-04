package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.bean.LiteMallExpress;
import com.cskaoyan.mall.mallStart.bean.LiteMallMall;
import com.cskaoyan.mall.mallStart.bean.LiteMallOrder;
import com.cskaoyan.mall.mallStart.bean.LiteMallWx;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminConfigServiceImpl implements AdminConfigService {

    @Autowired
    AdminConfigMapper mapper;

    @Override
    public LiteMallExpress selectLiteMallExpress() {
        return mapper.selectLiteMallExpress();
    }

    @Override
    public LiteMallMall selectLiteMallMall() {
        return mapper.selectLiteMallMall();
    }

    @Override
    public void updateLiteMallMall(LiteMallMall mallConfig) {
        mapper.updateLiteMallMall(mallConfig);
    }

    @Override
    public void updateLiteMallExpress(LiteMallExpress expressConfig) {
        mapper.updateLiteMallExpress(expressConfig);
    }

    @Override
    public LiteMallOrder selectLiteMallOrder() {
        return mapper.selectLiteMallOrder();
    }

    @Override
    public void updateLiteMallOrder(LiteMallOrder orderConfig) {
        mapper.updateLiteMallOrder(orderConfig);
    }

    @Override
    public LiteMallWx selectLiteMallWx() {
        return mapper.selectLiteMallWx();
    }

    @Override
    public void updateLiteMallWx(LiteMallWx wxConfig) {
        mapper.updateLiteMallWx(wxConfig);
    }
}
