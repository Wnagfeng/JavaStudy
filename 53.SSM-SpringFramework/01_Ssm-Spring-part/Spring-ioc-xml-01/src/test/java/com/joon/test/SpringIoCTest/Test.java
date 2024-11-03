package com.joon.test.SpringIoCTest;

import com.ioc_03.HappyComponent;
import com.ioc_05.JavaBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 讲解如何创建ioc容器并且能读取配置文件
public class Test {


    // 讲解如何在ioc容器中获取组件Bean
    public void createIoC() {
        //创建容器选择合适的容器实现即可！
        /*
         * 接口：BeanFactory、ApplicationContext
         * 实现类：
         * - ClassPathXmlApplicationContext：从类路径下加载配置文件
         * - FileSystemXmlApplicationContext：从文件系统中加载配置文件
         * - XmlWebApplicationContext：从Web应用的WEB-INF/下加载配置文件
         * - AnnotationConfigApplicationContext：从注解配置类中加载配置
         * */
        // 方案一：直接创建容器并且加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-03.xml");
        // 方案二：先创建ioc容器、再指定配置文件、再刷新
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocation("Spring-03.xml");
        classPathXmlApplicationContext.refresh();

    }

    // 讲解如何从ioc容器中获取Bean
    @org.junit.jupiter.api.Test
    public void getBeanFormIoc() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocation("Spring-03.xml");
        classPathXmlApplicationContext.refresh();
        System.out.println(classPathXmlApplicationContext);
        // 方式一：通过getBean方法获取Bean
        // 直接填写Bean的ID
        HappyComponent happyComponent = (HappyComponent) classPathXmlApplicationContext.getBean("happyComponent");
        // 方式二：根据Bean的ID和类型获取Bean
        // TODO: 根据bean的类型获，同一个类型，在ioc容器中只能有一个实例
        // TODO： 如果ioc容器中存在多个同一个类型的bean就会报错
        // TODO: IOC的配置一定的实现类，也可以是接口
        // 上面说的IOC配置其实就是Spring_03.xml文件中配置的Bean
        HappyComponent happyComponent1 = (HappyComponent) classPathXmlApplicationContext.getBean("happyComponent", HappyComponent.class);
        // 方式三：直接根据类型获取Bean
        HappyComponent happyComponent2 = (HappyComponent) classPathXmlApplicationContext.getBean(HappyComponent.class);
        happyComponent2.doWork();

        System.out.println(happyComponent);
        System.out.println(happyComponent1);
        System.out.println(happyComponent2);

    }

    @org.junit.jupiter.api.Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-04.xml");

    }

    @org.junit.jupiter.api.Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-05.xml");
        //    读取组件
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);

        System.out.println(javaBean.getName());
    }
}
