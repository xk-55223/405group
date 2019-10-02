package com.cskaoyan.mall.mallStart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.mall.mallStart.mapper")
public class MallApplication {

     public static void main(String[] args) {
         SpringApplication.run(MallApplication.class, args);
    }
}
