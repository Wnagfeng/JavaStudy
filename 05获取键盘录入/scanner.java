
// 01引入Scanner类
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        // 在java中 java已经帮我们封装好了获取键盘输入就在Scanner这个类中
        // 创建对象 表示我现在要使用这个对象了
        Scanner sc = new Scanner(System.in);
        // 接收数据
        // 变量i记录了键盘录入的数据
        System.out.println("请输入整数：");
        int i = sc.nextInt();
        System.out.println(i);
    }

}