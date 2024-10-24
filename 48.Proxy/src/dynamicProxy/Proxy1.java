package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy1 {
//    动态代理就是我们在开发中不会手动去写代理对象,jdk已经给我们提供好了,
//    动态代理就是对方法进行拦截,比如对宝强类中的某一个方法进行拦截
//    在被代理的对象运行前或者运行后进行一些操作
//    他对比静态代理的有点就是我们可以针对被代理对象中的某一个单独的方法进行丰富,试想一下
//    在静态代理中我们需要手写一个代理对象,然后去实现一个公共的接口,加入被代理对象
//    如果有几百个方法, 你一个一个的重写是不是太麻烦了?所以我建议你使用动态代理
//    动态代理可以对被代理对象中的某一个方法进行代理
public static void main(String[] args) {
//实现动态代理的步骤
//    1.创建被代理的类的加载器
    ClassLoader classloader =Baoqiang.class.getClassLoader();
//    2.创建被代理对象实现的所有的接口
    Class<?>[] interfaces = Baoqiang.class.getInterfaces();
//    3.获取代理角色对象
//    Object songZhe =Proxy.newproxyinstance(被代理的类的加载器,被代理对象实现的所有的接口 ,处理器InvocationHandler接口实现类对象 );
    Start songZhe = (Start) Proxy.newProxyInstance(classloader, interfaces, new InvocationHandlerImpl());
    songZhe.Sleep();
    songZhe.LiveShow(10000);
}
}
//处理器InvocationHandler接口实现类对象
class InvocationHandlerImpl implements InvocationHandler {
    private Baoqiang baoqiang;

    public InvocationHandlerImpl() {
        this.baoqiang = new Baoqiang();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Object proxy -- 代理对象(基本不用)
        // Method method -- 被调用的方法
        // Object[] args -- 方法的参数
        System.out.println("方法执行了");
        if (method.getName().equals("LiveShow")){
            System.out.println("LiveShow方法执行前");
            method.invoke(baoqiang, args[0]);
            System.out.println("LiveShow方法执行后");
        }
        return null;
    }
}
// 被代理的对象
class Baoqiang implements Start {
    @Override
    public void LiveShow(int money) {
        System.out.println("我是宝强，我正在直播，我要赚 " + money + " 元");
    }

    @Override
    public void Sleep() {
        System.out.println("我是宝强，我要睡觉");
    }
}
