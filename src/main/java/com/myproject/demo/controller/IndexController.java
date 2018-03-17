package com.myproject.demo.controller;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String indexLoad(Model m) {
        List<User> userList = userMapper.getAllUsers();
        /*测试用数据
        User user = new User();
        user.setId("0001");
        user.setAge(1992);
        user.setExist(true);
        user.setName("admin");
        user.setPass("admin000");
        user.setRank(0);
        user.setType(0);
        user.setTelnum("1234567890");
        user.setSex("男");
        userList.add(user);*/
        m.addAttribute("userList", userList);
        return "index";
    }
}
