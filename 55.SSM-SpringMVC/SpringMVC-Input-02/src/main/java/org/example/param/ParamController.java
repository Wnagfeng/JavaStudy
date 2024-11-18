package org.example.param;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 讲解如何接受praam参数的方式
@Controller
@RequestMapping("/param")
public class ParamController {
    //方式一：直接接受
    //要求：方法参数名和请求参数名一致
    //缺点：
    // 1.参数类型必须一致，不灵活；
    // 2.前端不传递参数时会报错（使用if判断规避风险）
    @RequestMapping("/data")
    @ResponseBody
    public String get(String name, int age) {
        System.out.println("方式一：直接接受参数");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        return "success";
    }

    // 方式二：指定注解接受
    //  指定任意请求参数名 要求必须传递 要求不必传递 给一个默认值
    @RequestMapping("/data1")
    @ResponseBody
    public String get1(@RequestParam(value = "name", required = true, defaultValue = "默认值") String name, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("方式二：指定注解接收参数");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        return "success";
    }

    // 方式三：集合接受参数
    // 特殊值：？key=1&key=2&key=3
    //http://localhost:8080/param/data2?hbs2=1&hbs2=2
    @RequestMapping("/data2")
    @ResponseBody
    public String get2(@RequestParam List<String> hbs2) {
        System.out.println("方式三：集合接受参数");
        System.out.println("hbs2: " + hbs2);
        return "success";
    }

    // 方式四：使用实体对象接收参数
    //http://localhost:8080/param/data3?name=CoderJoon&age=21
    @RequestMapping("/data3")
    @ResponseBody
    public String get3(User user) {
        System.out.println("方式四：使用实体对象接收参数");
        System.out.println("user: " + user);
        return "success";
    }
}
