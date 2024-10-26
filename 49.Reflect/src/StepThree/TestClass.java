package StepThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //    讲解第三步：通过获取构造器去创建对象
        //1.1获取字节码对象
        int a = 10;



        Class cat1 = Cat.class;
        //1.2获取公共的构造器并且初始化对象
        Constructor constructor = cat1.getConstructor();
        //1.3获取公共的构造器
        Cat cat = (Cat) constructor.newInstance();
        System.out.println(cat.getName());

        //2.1获取私有的构造器并且初始化对象
        // 这就是反射的好处即使他的构造器是私有的我们也能通过暴力反射去创建对象
        Constructor constructor2 = cat1.getDeclaredConstructor(String.class, int.class);

        constructor2.setAccessible(true); //记得暴力反射
        Cat cat2 = (Cat) constructor2.newInstance("Tom", 2);
        System.out.println(cat2.getName());
        System.out.println(cat2.getAge());
    }
}
