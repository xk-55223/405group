package com.cskaoyan.mall.mallStart.service;

import com.cskaoyan.mall.mallStart.mapper.AdminStatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminStatServiceImpl implements AdminStatService {

    @Autowired
    AdminStatMapper mapper;
}
