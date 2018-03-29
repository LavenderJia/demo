package com.myproject.demo.controller;

import com.myproject.demo.pojo.User;
import com.myproject.demo.service.UserService;
import com.myproject.demo.vo.UserVO;
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
    private UserService userService;

    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public String indexLoad(Model m) {
        List<UserVO> userList = userService.getUsers();
        m.addAttribute("userList", userList);
        m.addAttribute("user", new UserVO());
        return "index";
    }
}
