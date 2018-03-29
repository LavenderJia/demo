package com.myproject.demo.service;

import com.myproject.demo.pojo.User;
import com.myproject.demo.vo.UserVO;

import java.util.List;

public interface UserService {
    String getNewId();
    /** get the list of existent users*/
    List<UserVO> getUsers();

    UserVO getUserById(String id);

    boolean addUser(UserVO user);

    boolean updateUser(UserVO user);

    boolean deleteUser(UserVO user);
}
