package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class helloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
