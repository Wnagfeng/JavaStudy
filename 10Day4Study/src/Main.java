import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sr=new Scanner(System.in);
        System.out.println("请输入您的工资");
        double BaseMoey=sr.nextDouble();//基本工资
        double decament=BaseMoey*0.1;//需要扣的三险一金
        double YourMoney=BaseMoey-decament;//扣完三险一金后的工资
        if (YourMoney<5000){
            System.out.println("您不需要纳税");
            System.out.println("扣除三险一金后您的工资到手为："+YourMoney);
        }else {
            double Money=BaseMoey-YourMoney;
            if(Money>=0&&Money<=3000){
                System.out.println("您扣税后工资为："+YourMoney*0.03);
            } else if (Money>=3000&&Money<=12000) {
                System.out.println("您扣税后工资为："+YourMoney*0.1);
            }

            System.out.println(YourMoney);
            System.out.println("您的工资需要扣税");
        }



//​	0 ~ 3000元的部分，交税3%
//
//​	3000 ~ 12000元的部分，交税10%
//
//​	12000 ~ 25000的部分 ， 交税20%
//
//​	25000 ~ 35000的部分，交税25%
//
//​	35000 ~ 55000的部分，交税30%
//
//​	55000 ~ 80000的部分，交税35%
//
//​	超过80000的部分，交税45%
//
//                比如：黑马某学员入职一家企业后，税前工资是15000，则他每月该交个税的部分是15000-1500-5000=8500元，个税缴纳数额是3000×3%+5500×10%=640元。税后工资12860元。
//
//        请完成一个个税计算程序，在用户输入税前工资后，计算出他对应的纳税数额，以及税后工资为多少？
//
//### 训练提示
//
//        1. 工资的哪些部分是属于要纳税部分，如何计算？
//        2. 纳税比例有很多区间，用什么知识点能够对应多个区间？
//        3. 每个区间的纳税数额是多少，计算的规律是什么？
//
//### 解题方案
//
//        1. 使用多条件的if...else对应各个纳税梯度，分别计算每一个梯度的纳税数额。
//
//### 操作步骤
//
//        1. 提示用户输入税前工资，使用键盘录入让用户输入一个整数。
//        2. 计算工资中应交税部分。也就是去除三险一金和起征点数额。
//        3. 使用多条件if..else..对每个区间分别判断，用每个梯度的计算公式求出对应的纳税数额。
//        4. 根据求出的纳税数额求出税后工资。

    }
}