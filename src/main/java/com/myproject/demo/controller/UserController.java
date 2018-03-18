package com.myproject.demo.controller;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/{id}")
    @ResponseBody()
    public User getUserById(@PathVariable("id") String id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @RequestMapping("/getNewId")
    @ResponseBody()
    public String getNewUserId() {
        String id = String.format("%04d", userMapper.getUserNum() + 1);
        return id;
    }

    @RequestMapping("/add")
    public String addUser(@ModelAttribute(value="user")User user) {
        user.setExist(true);
        user.setAge(2018-user.getAge());
        userMapper.addUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute(value="user")User user) {
        user.setAge(2018-user.getAge());
        userMapper.updateUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam(value="userChoices")List<String> userChoices) {
        for (String b: userChoices) {
            System.out.println(b);
        }
        return "redirect:/index";
    }
}
