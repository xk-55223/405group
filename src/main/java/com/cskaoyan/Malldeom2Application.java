package com.cskaoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.mapper")
public class Malldeom2Application {

    public static void main(String[] args) {
        SpringApplication.run(Malldeom2Application.class, args);
    }

}
