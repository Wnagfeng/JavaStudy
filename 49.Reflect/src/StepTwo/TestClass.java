package StepTwo;


import java.lang.reflect.Constructor;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //    讲解第二步：获取构造器
        //    有四种方法可以获取Class对象的构造器：
        //    1.getconstructors()：获取所有public构造器
        //    2.getdeclaredconstructors()：获取所有构造器，包括public、protected、default和private
        //    3.getConstructor(Class... parameterTypes)：获取指定参数类型的public构造器
        //    4.getDeclaredConstructor(Class... parameterTypes)：获取指定参数类型的构造器，包括public、protected、default和private


        // 第一步还是先获取类的字节码对象
        Class cat = Cat.class;
        //演示getconstructors()方法
        Constructor[] constructors = cat.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("----------------------------------------");
        //演示getdeclaredconstructors()方法
        Constructor[] declaredConstructors = cat.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("------------------------------------------");
        //演示getConstructor(Class... parameterTypes)方法
        Constructor constructor1 = cat.getConstructor();
        System.out.println(constructor1);
        System.out.println("--------------------------------------------");
        //演示getDeclaredConstructor(Class... parameterTypes)方法
        Constructor declaredConstructor1 = cat.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor1);


    }
}
