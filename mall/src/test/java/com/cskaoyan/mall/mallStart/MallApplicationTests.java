package com.cskaoyan.mall.mallStart;

import com.cskaoyan.mall.mallStart.bean.Region;
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminMallMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @Autowired
    AdminMallMapper mapper;

    @Test
    public void contextLoads() {
        List<Region> regions = mapper.selectRegions();
        System.out.println(regions);
    }
}
