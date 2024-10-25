package CoreClasses;

public class example {
    //演示反射中的核心类
    public static void main(String[] args) {
        //Class.forName 方法用于将指定的类加载到jvm虚拟机，并返回class对象
        try {
            Class personClass =Class.forName("CoreClasses.Person");
            System.out.println("Person class loaded successfully.");
            //newInstance 方法用于创建类的实例
            Person person = (Person) personClass.newInstance();
            person.setName("John");// 设置属性值
            person.setAge(25);// 设置属性值
            System.out.println(person);
        } catch (ClassNotFoundException e) {
            //如果类不存在，则抛出运行时异常
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            // 如果类不能被实例化，则抛出运行时异常
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            // 如果类不能被访问，则抛出运行时异常
            throw new RuntimeException(e);
        }
    }
}
