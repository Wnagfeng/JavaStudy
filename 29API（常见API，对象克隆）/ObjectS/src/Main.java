import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // 演示 Objects.isNull() 和 Objects.nonNull() 方法

        // 示例对象
        String str1 = null;
        String str2 = "Hello, World!";

        // 检查对象是否为 null
        if (Objects.isNull(str1)) {
            System.out.println("str1 是 null");
        } else {
            System.out.println("str1 不是 null");
        }

        // 检查对象是否非 null
        if (Objects.nonNull(str2)) {
            System.out.println("str2 不是 null");
        } else {
            System.out.println("str2 是 null");
        }
    }
}
