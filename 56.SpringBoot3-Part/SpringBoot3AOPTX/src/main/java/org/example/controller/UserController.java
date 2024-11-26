package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/get")
    public List<User> getUser() {
        return userService.getUserList();
    }

    @DeleteMapping("/delete")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
