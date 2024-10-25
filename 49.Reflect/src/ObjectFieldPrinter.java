import java.lang.reflect.Field;

public class ObjectFieldPrinter {

    // 定义方法来接收任意对象并打印字段名和对应的值
    public static void printObjectFields(Object obj) {
        Class<?> clazz = obj.getClass(); // 获取对象的Class对象
        Field[] fields = clazz.getDeclaredFields(); // 获取所有的成员变量

        // 遍历字段并打印名称和值
        for (Field field : fields) {
            field.setAccessible(true); // 设置访问权限

            try {
                String fieldName = field.getName(); // 获取字段名称
                Object value = field.get(obj); // 获取字段值
                System.out.println(fieldName + ": " + value); // 打印字段名和值
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // 处理异常
            }
        }
    }

    public static void main(String[] args) {
        // 示例对象
        ExampleObject example = new ExampleObject("Alice", 30);

        // 打印对象字段
        printObjectFields(example);
    }
}

// 示例对象类
class ExampleObject {
    private String name;
    private int age;

    public ExampleObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
