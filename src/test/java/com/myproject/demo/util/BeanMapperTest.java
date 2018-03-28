package com.myproject.demo.util;

import com.myproject.demo.pojo.User;
import com.myproject.demo.vo.UserVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class BeanMapperTest {

    @Test
    public void toUser() {
        UserVO userVO = new UserVO();
        userVO.setId("0001");
        userVO.setBirthYear(1983);
        userVO.setName("admin");
        userVO.setPass("admin000");
        userVO.setRank(0);
        userVO.setType(0);
        userVO.setTelnum("1234567890");
        userVO.setSex("男");
        User user = BeanMapper.toUser(userVO);
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        Assert.assertEquals(user.getAge(), Integer.parseInt(year) - 1983);
        System.out.println(user);
    }
}