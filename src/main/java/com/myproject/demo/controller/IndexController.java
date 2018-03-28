package com.myproject.demo.controller;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public String indexLoad(Model m) {
        List<User> userList = userMapper.getAllUsers();
        m.addAttribute("userList", userList);
        m.addAttribute("user", new User());
        return "index";
    }
}
