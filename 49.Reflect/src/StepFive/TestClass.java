package StepFive;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

  public static void main(String[] args)
    throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    //    讲解第五步：从类中获取成员方法的Api
    //    1.getMethods()：获取所有公共方法，包括从父类继承的公共方法(自己和object类的方法)。
    //    2.getDeclaredMethods()：获取所有方法，包括私有方法和受保护方法(不包含从父类继承的)。
    //    3.getMethod(String name, Class<?>... parameterTypes)：根据方法名和参数类型获取指定方法。
    //    4.getDeclaredMethod(String name, Class<?>... parameterTypes)：根据方法名和参数类型获取指定私有方法。

    //invoke 方法：调用方法，可以传递参数。

    //  第一步获取类的字节码对象
    Class clazz = Class.forName("StepFive.Cat");
    //  获取方法对象
    // 获取方法对象
    Method getNameMethod = clazz.getDeclaredMethod("getName");
    Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
    //通过反射获取方法并且调用
    // 创建 Cat 对象
    Object obj = clazz.newInstance();
    // 使用反射设置 name 的值
    setNameMethod.invoke(obj, "Tom");

    // 获取 name 的值
    String name = (String) getNameMethod.invoke(obj);

    // 打印结果
    System.out.println("设置的名字: Tom");
    System.out.println("获取的名字: " + name);
  }
}
