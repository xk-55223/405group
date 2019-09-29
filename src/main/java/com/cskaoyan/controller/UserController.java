package com.cskaoyan.controller;

import com.cskaoyan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("user1")
    public String getUserNameById(int id) {
        String s = userMapper.selectUsernameById(id);
        return s;
    }
}
