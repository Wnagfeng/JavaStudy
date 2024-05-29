import java.util.Scanner;;

public class scannerTest {
    public static void main(String[] args) {
        // 让用户输入两个数据 求和后输出
        Scanner sc = new Scanner(System.in);
        System.err.println("请输入数字1：");
        double num1 = sc.nextDouble();
        System.err.println("请输入数字2：");
        double num2 = sc.nextDouble();
        double result = num1 + num2;
        System.err.println("您的求和为：" + result);

    }

}