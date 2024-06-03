import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 键盘录入1-100之间的整数 并且添加到集合中
//        直到集合中所有的数据和超过200停止录入

//        1. 创建集合(Integer是Java的基本数据类型)
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        // 2. 循环录入数据
        while (sum <= 200) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入一个整数(1-100)：");
            int num = scanner.nextInt();
            if (num >= 1 && num <= 100) {
                list.add(num);
                sum += num;
            } else {
                System.out.println("输入的数字不在1-100之间，请重新输入！");
            }
        }

        // 7. 输出最终的集合
        System.out.println("最终的集合：" + list);

    }
}