package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
// 这里就是为了是实现吧我们的核心功能加入到ioc容器中写的配置类

/**
 * projectName: com.atguigu.config
 *
 * @author: 赵伟风
 * description: 配置类
 */

@Configuration
@ComponentScan("org.example")
@EnableAspectJAutoProxy //开启aspectj的注解 要不然你的切面注解不会生效 <aop:aspectj-autoproxy />
public class JavaConfig {
}
