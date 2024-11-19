package org.example.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
    // 尝试返回一个视图
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        request.setAttribute("data", "World");
        // 由于我们在MVCConfig中配置了解析器，我们这里只需要返回对应的jsp文件名即可
        // mvc会自动查找jsp文件并渲染
        return "index";
    }

    //    尝试进行页面转发
    @GetMapping("/forward")
    public String forward() {
        // 这里我们返回一个forward请求，会自动跳转到/jsp/hello页面
        // 注意这里的forward:前缀，代表页面转发 你如果不写forward:前缀，则会发生404错误，因为它会默认走页面的渲染
        return "forward:/jsp/hello"; // 这里写的是你要转发到的页面的url
    }

    //     尝试进行重定向
    @GetMapping("/redirect")
    public String redirect() {
        // 这里我们返回一个redirect请求，会自动跳转到/jsp/hello页面
        // 注意这里的redirect:前缀，代表页面重定向 你如果不写redirect:前缀，则会发生404错误，因为它会默认走页面的渲染
        return "redirect:/jsp/hello"; // 这里写的是你要重定向到的页面的url
    }
}
