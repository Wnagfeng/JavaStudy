package org.example.controller;

import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloWordController {
    @Autowired
    private User user;

    @GetMapping("/Word")
    public String helloWord() {
        return "Hello Word!";
    }

    @GetMapping("/RedFile")
    public User redFile() {
        return user;
    }
}
