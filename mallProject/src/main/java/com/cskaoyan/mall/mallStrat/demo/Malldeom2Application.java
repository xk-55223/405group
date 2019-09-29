package com.cskaoyan.my1.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.my1.demo.mapper")
public class Malldeom2Application {

    public static void main(String[] args) {
        SpringApplication.run(Malldeom2Application.class, args);
    }

}