package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan({"org.example.User", "org.example.error"})
// 你需要去实现WebMvcConfigurer
public class MVCConfig implements WebMvcConfigurer {
    //    视图解析器配置
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 注册jsp视图解析器
        // 其实就是为了把试图发给浏览器渲染
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    //开启静态资源查找
    // dispatcherServlet -> handlerMapping找有没有对应的handler -》【 没有 -》 找有没有静态资源 】
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
