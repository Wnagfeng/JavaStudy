// 自定义异常类
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    // 使用 throws 声明方法可能抛出异常
    public static void checkAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("年龄必须大于或等于 18 岁！"); // 使用 throw 抛出异常
        } else {
            System.out.println("年龄合法，可以继续执行！");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // 这里会抛出异常
        } catch (CustomException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }

        try {
            checkAge(20); // 这里是合法的年龄
        } catch (CustomException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }
    }
}
