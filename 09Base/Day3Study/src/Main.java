

import  java.util.Scanner;
public class Main {
    //    运算符的演示
    public static void main(String[] args) {
//        从键盘获取一个三位数 把它分来打印
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int number=sc.nextInt();
        int ge=number%10;
        int shi=number/ 10%10   ;
        int bai=number /100%10 ;




        System.out.println("您的输入为：");
        System.out.println("个位是："+ge);
        System.out.println("十位是："+shi);
        System.out.println("百位是："+bai);
    }
}