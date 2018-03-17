package com.myproject.demo.controller;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/getNewId")
    public String getNewUserId() {
        String id = String.format("%04d", userMapper.getUserNum() + 1);
        return id;
    }
}
