import java.util.Scanner;

public class Testphoen {
    public static void main(String[] args) {

        //    创建三个对象数组去存储三个手机对象
        Phone[] phone = new Phone[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < phone.length; i++) {
//创建一个对象用于存储用户输入的内容
            Phone p = new Phone(); //初始化对象一定要在内部
            System.out.println("请输入" + i + "号手机的品牌");
            String brand = sc.next();
            p.setPhoenbrand(brand);
            System.out.println("请输入" + i + "号手机的颜色");
            String color = sc.next();
            p.setPhoencolor(color);
            System.out.println("请输入" + i + "号手机的价格");
            int price = sc.nextInt();
            p.setPhoenprce(price);
            phone[i] = p;

        }
        System.out.println("您的输入结果为：");
        double AveragePrice =0.00;
        double sumberPrice = 0.00;
        for (int i = 0; i < phone.length; i++) {
            Phone p = phone[i];
            System.out.println("汽车品牌" + p.getPhoenbrand() + "汽车价格" + p.getPhoenprce() + "汽车颜色" + p.getPhoencolor());
            sumberPrice = sumberPrice + p.getPhoenprce();
            AveragePrice = sumberPrice / 3;

        }
        System.out.println("三个手机的平均价格为：" + AveragePrice);
        System.out.println("三个手机的总价格为：" + sumberPrice);
    }
}
