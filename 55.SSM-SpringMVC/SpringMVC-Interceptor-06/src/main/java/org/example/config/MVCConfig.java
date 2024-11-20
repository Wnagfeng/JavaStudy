package org.example.config;

import org.example.Interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan("org.example.User")
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

    //    注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置方案1： 拦截全部请求
        //registry.addInterceptor(new MyInterceptor());

        //配置方案2： 指定地址拦截 .addPathPatterns("/user/data");
        //   *  任意一层字符串   ** 任意多层字符串
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/user/**");

        //配置方案3：排除拦截 排除的地址应该在拦截地址内部！
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/user/**").excludePathPatterns("/user/data1");
        // 注册一个拦截器   /user/** 所有以/user开头的请求都经过这个拦截器
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
    }

}
