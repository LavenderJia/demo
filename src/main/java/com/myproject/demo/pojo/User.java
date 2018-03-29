package com.myproject.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String id;
    private String name;
    private String pass;
    private String sex;
    private int age;
    private int rank;
    private int type;
    private String telnum;
    private boolean exist;
}
