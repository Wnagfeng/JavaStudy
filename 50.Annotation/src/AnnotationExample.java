import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationExample {
    public static void main(String[] args) {
        try {
            // 使用 getDeclaredMethod 代替 getMethod（ 获取方法）
            Method method = MyClass.class.getDeclaredMethod("myMethod");
            // 判断方法是否有 MyAnnotation 注解
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("注解的值: " + annotation.value());
            }

            // 获取 MyClass 类的字段
            Field field = MyClass.class.getDeclaredField("name");
            // 判断字段是否有 Name 注解
            if (field.isAnnotationPresent(Name.class)) {
                Name name = field.getAnnotation(Name.class);
                System.out.println("字段名: " + name.value());
            }

            // 创建 MyClass 的实例并调用 myMethod()
            MyClass myClassInstance = new MyClass();
            method.setAccessible(true); // 允许访问私有方法
            method.invoke(myClassInstance); // 调用方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
