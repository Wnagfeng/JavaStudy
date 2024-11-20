package org.example.User;

import org.example.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
//模拟ResutfulAPI 对用户数据进行增删改查
public class UserController {
    //    1.分页查询 param参数 pageNum,pageSize
    @GetMapping("/list")
    public String list(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        System.out.println("pageNum:" + pageNum + ",pageSize:" + pageSize);
        // 把当前的分页参数返回给前端，前端根据分页参数进行分页查询
        return "pageNum:" + pageNum + ",pageSize:" + pageSize;

    }

    //    2.新增用户
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        System.out.println("新增用户:" + user);
        // 新增用户并返回成功信息
        return "User Add Success!";
    }

    //    3.删除用户
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {   //PathVariable注解用于获取路径参数
        System.out.println("删除用户id:" + id);
        // 删除用户并返回成功信息
        return "User Delete Success!";
    }

    //    4.修改用户
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        System.out.println("修改用户:" + user);
        // 修改用户并返回成功信息
        return "User Update Success!";
    }

    //    5.查询用户
    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") int id) {   //PathVariable注解用于获取路径参数
        System.out.println("查询用户id:" + id);
        // 查询用户并返回用户信息
        User user = new User();
        user.setId(id);
        user.setName("Tom");
        user.setAge(20);
        return user;
    }
}
