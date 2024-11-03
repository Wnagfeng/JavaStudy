package com.ioc_02;

public class UserService1 {

    private UserDao userDao;

    private int age;

    private String name;

    public UserService1(int age, String name, UserDao userDao) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }
}