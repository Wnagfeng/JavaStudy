package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration//使用@Configuration的类会被自动扫描并注册到Spring的应用上下文中
@ComponentScan("org.example")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement//开启事务管理
public class Javaconfig {
    @Value("${atguigu.driver}")
//@Value("${atguigu.driver}") 注解用于从外部配置文件中注入一个属性值。在此上下文中，它的作用是将jdbc.properties文件中键为atguigu.driver对应的值注入到driver字段中。
    private String driver;
    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;

    //druid连接池
    /*
     * 创建bean：当方法被调用时，
     * 返回的对象会作为一个bean实例被管理。
     * 例如，在你的代码中，dataSource()方法和jdbcTemplate()方法都被标记为@Bean，
     * 这意味着返回的DruidDataSource和JdbcTemplate实例将被Spring容器管理。
     * 依赖注入：通过@Bean注解创建的bean可以被其他bean注入使用。
     * 在你的代码中，jdbcTemplate()方法有一个参数DataSource dataSource，
     * Spring会自动将dataSource bean注入到这个方法中。
     * */


    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;  // 返回 DruidDataSource，它是 DataSource 的实现
    }


    @Bean
    //jdbcTemplate
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource((javax.sql.DataSource) dataSource);
        return jdbcTemplate;
    }

    @Bean
    public TransactionManager transactionManager() {
        //   开启事务第一步： 需要创建一个连接池
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());//设置连接池
        return dataSourceTransactionManager;
    }
}
