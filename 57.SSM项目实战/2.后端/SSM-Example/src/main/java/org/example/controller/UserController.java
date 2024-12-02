package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //    登录接口
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    //    根据Token获取用户信息接口
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {
        System.out.println("token: " + token);
        Result result = userService.getUserInfo(token);
        return result;
    }

    //    检查用户名是否存在接口
    @GetMapping("/checkUsername")
    public Result checkUsername(@RequestParam String username) {
        Result result = userService.checkUsername(username);
        return result;
    }

    //    注册接口
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        Result result = userService.register(user);
        return result;
    }

    //    检查Token是否有效接口
    @GetMapping("/checkToken")
    public Result checkToken(@RequestHeader String token) {
        Result result = userService.checkToken(token);
        return result;
    }
}
