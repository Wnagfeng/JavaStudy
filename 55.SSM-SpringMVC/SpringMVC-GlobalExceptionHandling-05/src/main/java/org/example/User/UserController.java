package org.example.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //    模拟空指针异常
    @GetMapping("/user1")
    public String getUser() {
        String name = null;
        return "Hello " + name.toUpperCase();
    }

    @GetMapping("/user2")
    //    模拟算数异常
    public int add(int a, int b) {
        int result = a / b;
        return result;
    }
}
