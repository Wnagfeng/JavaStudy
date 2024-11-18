package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * projectName: com.atguigu.config
 *
 * @author: CoderJoon
 * description:
 * <p>
 * 1. controller配置ioc容器
 * 2. handlerMapping  handlerAdapter加入到ioc容器
 */

@Configuration //配置类标签
@ComponentScan("org.example.controller")// 你需要扫描的包的位置
public class MvcConfig {
    // 把RequestMappingHandlerMapping和RequestMappingHandlerAdapter加入到ioc容器

    @Bean // @Baan 可以自动加入到ioc容器
    public RequestMappingHandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

}
