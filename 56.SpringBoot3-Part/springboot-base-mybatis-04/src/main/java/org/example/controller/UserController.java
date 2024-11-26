package org.example.controller;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/get")
    public List<User> getUser() {
        List<User> userList = userMapper.selectAll();
        return userList;
    }
}
