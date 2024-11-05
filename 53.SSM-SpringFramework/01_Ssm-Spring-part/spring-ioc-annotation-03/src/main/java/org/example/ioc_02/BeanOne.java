package org.example.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //单例,默认值
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例  二选一
@Component
public class BeanOne {

    //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
    @PostConstruct  //注解制指定初始化方法
    public void init() {
        // 初始化逻辑
    }

    @PreDestroy //注解指定销毁方法
    public void cleanup() {
        // 释放资源逻辑
    }
}

