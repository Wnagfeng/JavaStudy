package org.example.patch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 讲解如何进行路径接受参数
@Controller
@RequestMapping("/patch")
@ResponseBody
public class PatchConrtoller {
    // 动态路径参数
    //http://localhost:8080/patch/data/CoderJoon/123456
    @RequestMapping(value = "/data/{username}/{password}")
    //我们必须使用@PathVariable注解来绑定动态路径参数 要不然你拿不到参数
    public String patch(@PathVariable String username, @PathVariable String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        return "Patching...";
    }
}
