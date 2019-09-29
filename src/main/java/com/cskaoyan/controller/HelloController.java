package com.cskaoyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(String message) {
        System.out.println("hello:------" + message);
        return "hello:------" + message;
    }
}
