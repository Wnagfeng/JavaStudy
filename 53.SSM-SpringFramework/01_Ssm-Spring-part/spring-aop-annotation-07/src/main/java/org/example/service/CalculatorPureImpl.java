package org.example.service;


import org.springframework.stereotype.Component;
// 这里是我们 的核心功能的实现类

/**
 * 实现计算接口,单纯添加 + - * / 实现! 掺杂其他功能!
 * <p>
 * aop - 只针对ioc容器的对象 - 创建代理对象 -> 代理对象存储到ioc容器
 * 所以你必须放到ioc容器中 (写个配置类或者配置文件就行了)
 */
@Component
public class CalculatorPureImpl implements Calculator {


    public int add(int i, int j) {


        int result = i + j;

        return result;
    }


    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }


    public int mul(int i, int j) {

        int result = i * j;

        return result;
    }


    public int div(int i, int j) {

        int result = i / j;

        return result;
    }
}