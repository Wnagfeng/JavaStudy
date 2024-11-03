package com.ioc_04;

//声明生命周期方法

public class HappyComponent {

    public void init() {
        System.out.println("HappyComponent.init[初始化成功]");
    }

    public void destroy() {
        System.out.println("HappyComponent.destroy");
    }


    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}