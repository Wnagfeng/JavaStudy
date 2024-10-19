import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("请输入一个整数：");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input); // 可能抛出 NumberFormatException

            System.out.print("请输入一个除数：");
            int divisor = Integer.parseInt(scanner.nextLine()); // 可能抛出 NumberFormatException

            int result = number / divisor; // 可能抛出 ArithmeticException
            System.out.println("结果是：" + result);
        } catch (NumberFormatException e) {
            System.out.println("输入无效，必须是一个整数：" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("错误：不能除以零：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生了其他异常：" + e.getMessage());
        } finally {
            scanner.close(); // 关闭资源
            System.out.println("程序结束。");
        }
    }
}
