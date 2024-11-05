package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//标注当前类是配置类，替代application.xml
@Configuration
/*
 *ComponentScan 这里可以写多个包名，Spring会扫描这些包下的所有类，并将其注册到Spring容器中。
 *  */
@ComponentScan({"org.example.ioc_01"})
/*
 *  PropertySource 这里可以指定配置文件的位置，Spring会从这个位置加载配置信息。
 * */
@PropertySource("classpath:jdbc.properties")
public class MyConfiguration {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // 配置第三方类注入
    //  方法的返回值是Bean组件的类型或者其他接口和父类
    // 方法的名字就是Bean的id
    //一下就相当于我们之前在application.xml中配置的bean
    /*
     * 关于注解的使用的问题：
     * 问题一：
     * 之前我们在xml中配置的bean在这里就是直接写方法就行了
     * 问题二：beanName的问题
     * 在之前xml中我们设置的id在这里我们直接使用@Bean(name="xxx")
     * 问题三：作用域的问题
     * 和以前还是一样@Scope注解，默认是单例
     *  问题四：如何引用其他的ioc组件
     *  直接调用对方的bean方法即可
     *  直接形参变量进行引入，要求必须有对应的组件，如果有多个，形参名 = 组件id标识即可
     * */

    // 演示问题一：
    // 之前在xml中我们是这样设置的
    /*
    *   <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${atguigu.url}"/>
        <property name="driverClassName" value="${atguigu.driver}"/>
        <property name="username" value="${atguigu.username}"/>
        <property name="password" value="${atguigu.password}"/>
        </bean>
    * */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //  演示问题二：name问题
    @Bean(name = "dataSource1")
    public DruidDataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSource2")
    public DruidDataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 演示问题三和四：如何引用其他的ioc组件和命名的问题
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        //方案1： 如果其他组件也是@Bean方法，可以直接调用 | 从ioc容器获取组件
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource1, DataSource dataSource2) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        //方案2： 形参列表声明想要的组件类型，可以是一个也可以是多个！  ioc容器也会注入
        //如果没有：形参变量注入。要求必须有对应的类型的组件，如果没有抛异常！
        //如果有多个：可以使用形参名称等同于对应的beanid标识即可
        jdbcTemplate.setDataSource(dataSource1);
        return jdbcTemplate;
    }
}
