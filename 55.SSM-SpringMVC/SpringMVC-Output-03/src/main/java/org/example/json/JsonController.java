package org.example.json;

import org.example.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //@Controller + @ResponseBody
/*
 * 我们之前在这里写的都是@Controller注解，
 * 现在我们需要模拟前后端分离的开发模式我们这里直接写@RestController注解，
 * 如果你写了@RestController注解它就相当于你写了@Controller和@ResponseBody注解，
 * 它会自动将返回的数据转换为json格式，并将json格式的数据返回给前端。
 * 就是把你返回的类对象或者集合转换为json格式的数据，并返回给前端。
 *
 * 一旦你写了@RestController 那么它就不会在走视图解析器了，
 * 它会直接将你返回的数据转换为json格式，并返回给前端。
 * */
@RequestMapping("json")
public class JsonController {
    //    尝试返回Json数据
    @GetMapping("data")
    public User data() {
        // 对象 -》json -> {}
        // 集合 -》json -> []
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);
        return user; // user-> handlerAdapter -> json -》 @ResponseBody -> json直接返回 【前后端分离模式】
    }

    //    尝试返回Json数据
    @GetMapping("data2")
    public List<User> data1() {
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);

        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

}
