package com.myproject.demo.mapper;

import com.myproject.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.type.JdbcType.*;

public interface UserMapper {

    @Results(id="userResult", value = {
            @Result(id=true, column="SUId", property = "id", javaType = String.class, jdbcType=VARCHAR),
            @Result(column = "SUName", property = "name", javaType = String.class, jdbcType = VARCHAR),
            @Result(column = "SUPwd", property = "pass", javaType = String.class, jdbcType = VARCHAR),
            @Result(column = "SUSex", property = "sex", javaType = String.class, jdbcType = VARCHAR),
            @Result(column = "SUBirth", property = "age", javaType = Integer.class, jdbcType = INTEGER),
            @Result(column = "SUDept", property = "type", javaType = Integer.class, jdbcType = INTEGER),
            @Result(column = "SURank", property = "rank", javaType = Integer.class, jdbcType = INTEGER),
            @Result(column = "SUTel", property = "telnum", javaType = String.class, jdbcType = VARCHAR),
            @Result(column = "SUIsExist", property = "exist", javaType = Boolean.class, jdbcType = BOOLEAN)})
    @Select("SELECT * FROM SystemUser WHERE SUId = #{id}")
    User getUserById(@Param("id") String id);

    @ResultMap("userResult")
    @Select("SELECT * FROM SystemUser")
    List<User> getAllUsers();

    @ResultType(Integer.class)
    @Select("SELECT Count(*) FROM SystemUser")
    int getUserNum();
}
