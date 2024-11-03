package org.example;

import com.ioc_01.ClientService;
import com.ioc_01.DefaultServiceLocator;
import com.ioc_01.HappyComponent;

public class Main {
    public static void main(String[] args) {
        // 演示普通的创建实例
        HappyComponent happyComponent = new HappyComponent();
        happyComponent.doWork();
        // 使用静态工厂方法获取 ClientService 实例
        ClientService clientService = ClientService.createInstance();
        // 非静态工厂方法获取 ClientService 实例
        DefaultServiceLocator serviceLocator = new DefaultServiceLocator();
        serviceLocator.createClientServiceInstance();
        //其实通过上面的演示 基本bean的创建和我们的手动是一样的
        //最难理解的是 非静态工厂的实例的创建，有静态方法我们不用new【因为静态方法属于类的本身】 直接调用就行了
        //而没有静态方法的我们需要先创建对象的实例然后去调用创建实例的方法去创建对象



        System.out.println("Hello world!");
    }
}