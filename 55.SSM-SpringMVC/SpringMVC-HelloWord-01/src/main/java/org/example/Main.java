package org.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class Main implements WebApplicationInitializer {
    public static void main() {
        System.out.println("Hello world!");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //    这个方法只要我们的javaweb项目一旦启动就会自动调用该接口的onStartup方法，我们可以在该方法中进行一些初始化工作，比如注册servlet、filter等等。
        System.out.println("我是onStartup方法");
    }
}