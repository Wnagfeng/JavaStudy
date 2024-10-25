package StepFour;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestClass {

  public static void main(String[] args)
    throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    //    讲解第四步：获取成员变量并且对齐进行操作
    // 获取成员变量的方法：
    // 1.getFileds()方法：获取类的成员变量，返回一个Field数组（只有public的成员变量）。
    // 2.getDeclaredFields()方法：获取类的所有成员变量，包括私有成员变量，返回一个Field数组。
    // 3.getField()方法：获取指定名称的成员变量，返回一个Field对象(只有public的成员变量)。
    // 4.getDeclaredField()方法：获取指定名称的成员变量，包括私有成员变量，返回一个Field对象。
    // 5.setAccessible(true)方法：设置访问权限为true，可以访问私有成员变量。
    // 6.setAccessible(false)方法：设置访问权限为false，禁止访问私有成员变量。
    //     1.获取类的字节码对象
    Class cat = Cat.class;
    //   2.获取类的成员变量
    Field[] fields = cat.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(field.getName());
    }

    System.out.println("---------------------------");

    Field[] field = new Field[] { cat.getDeclaredField("name") };
    System.out.println(field[0].getName());

    System.out.println("---------------------------");
    //修改name成员变量的值
    //1.获取类的字节码对象
    Class cat1 = Cat.class;
    //2.创建Cat对象(反射)
    Constructor constructor = cat1.getDeclaredConstructor();
    Cat cat2 = (Cat) constructor.newInstance();
    //获取name成员变量
    Field NameField = cat1.getDeclaredField("name");
    //3.设置访问权限为true
    NameField.setAccessible(true);
    //4.修改name成员变量的值
    NameField.set(cat2, "Tom");
    // 5.获取name成员变量的值
    System.out.println(NameField.get(cat2));
    //6.设置age成员变量的值
    Field ageField = cat1.getDeclaredField("age");
    ageField.setAccessible(true);
    ageField.set(cat2, 2);
    //7.获取age成员变量的值
    System.out.println(ageField.get(cat2));
    //8.打印cat2对象
    System.out.println(cat2.getAge() + " " + cat2.getName());
  }
}
