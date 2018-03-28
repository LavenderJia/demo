package com.myproject.demo.util;

import com.myproject.demo.pojo.User;
import com.myproject.demo.vo.UserVO;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

import java.util.Calendar;

public class BeanMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles("dozer/dozer-mapping.xml").build();

    public static User toUser(UserVO userVO) {
        User user = mapper.map(userVO, User.class);
        user.setAge(getYear() - userVO.getBirthYear());
        user.setExist(true);
        return user;
    }

    public static UserVO toUserVO(User user) {
        UserVO userVO = mapper.map(user, UserVO.class);
        userVO.setBirthYear(getYear() - user.getAge());
        return userVO;
    }

    private static int getYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return Integer.parseInt(year);
    }
}
