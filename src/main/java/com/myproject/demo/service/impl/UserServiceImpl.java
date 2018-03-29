package com.myproject.demo.service.impl;

import com.myproject.demo.mapper.UserMapper;
import com.myproject.demo.pojo.User;
import com.myproject.demo.service.UserService;
import com.myproject.demo.util.BeanMapper;
import com.myproject.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String getNewId() {
        int count = userMapper.getUserNum();
        return String.format("%04d", count + 1);
    }

    @Override
    public List<UserVO> getUsers() {
        List<User> userList = userMapper.getAllUsers();
        List<UserVO> userVOList = new LinkedList();
        for (User user : userList) {
            if (user.isExist()) userVOList.add(BeanMapper.toUserVO(user));
        }
        return userVOList;
    }

    @Override
    public UserVO getUserById(String id) {
        return BeanMapper.toUserVO(userMapper.getUserById(id));
    }

    @Override
    public boolean addUser(UserVO user) {
        userMapper.addUser(BeanMapper.toUser(user));
        return true;
    }

    @Override
    public boolean updateUser(UserVO user) {
        userMapper.updateUser(BeanMapper.toUser(user));
        return true;
    }

    @Override
    public boolean deleteUser(UserVO user) {
        return false;
    }

}
