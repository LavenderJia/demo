package com.myproject.demo.controller;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.service.UserService;
import com.myproject.demo.vo.UserVO;
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
    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody()
    public UserVO getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/getNewId")
    @ResponseBody()
    public String getNewUserId() {
        return userService.getNewId();
    }

    @RequestMapping("/add")
    public String addUser(@ModelAttribute(value="user")UserVO user) {
        userService.addUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute(value="user")UserVO user) {
        userService.updateUser(user);
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
