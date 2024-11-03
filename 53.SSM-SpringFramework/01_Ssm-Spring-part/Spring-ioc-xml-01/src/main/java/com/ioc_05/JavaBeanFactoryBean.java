package com.ioc_05;

import org.springframework.beans.factory.FactoryBean;

//制造JavaBean的工厂的Bean对象
/*
 * 1.实现FactoryBean接口
 * 2.实现getObject()方法，返回JavaBean对象
 * */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    @Override
    public JavaBean getObject() throws Exception {
        //使用你自己的方式实例化对象就行了
        JavaBean javaBean = new JavaBean();
        javaBean.setName("Tom");
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        //返回JavaBean的类型
        return JavaBean.class;
    }

}
