package com.myproject.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
    private String id;
    private String name;
    private String pass;
    private String sex;
    private int birthYear;
    private int rank;
    private int type;
    private String telnum;
}
