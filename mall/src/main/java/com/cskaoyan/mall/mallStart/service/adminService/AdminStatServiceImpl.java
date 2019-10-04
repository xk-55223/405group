package com.cskaoyan.mall.mallStart.service.adminService;

import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminStatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminStatServiceImpl implements AdminStatService {

    @Autowired
    AdminStatMapper mapper;
}
