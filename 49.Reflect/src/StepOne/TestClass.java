package StepOne;

public class TestClass {

  public static void main(String[] args) throws ClassNotFoundException {
    //    讲解第一步：加载类，获取类的字节码Class对象
    //   有三种方法可以获取Class对象：
    //    1. 通过类名获取：Class clazz = Class.forName("包名.类名");
    //    2. 通过对象获取：Class clazz = obj.getClass();
    //    3. 通过类加载器获取：Class clazz = ClassLoader.getSystemClassLoader().loadClass("包名.类名");
    //1.
    Class cat1 = Cat.class;
    //2.
    Class cat2 = Class.forName("StepOne.Cat");
    //3.
    Cat p = new Cat();
    Class cat3 = p.getClass();
    System.out.println(cat1 == cat2);
    System.out.println(cat1 == cat3);
  }
}
