package example;

import java.util.Scanner;

public class compute {
    //使用传统方式实现计算器
    // 使用这种方案实现起来，如果我们需要继续添加乘法和除法就需要继续判断，非常的不人性
    //public static void main(String[] args) {
    //    Scanner scanner =new Scanner(System.in);
    //    System.out.print("请输入计算类名： ");
    //    String className = scanner.next();
    //    System.out.println("请输入数字1：");
    //    int num1 = scanner.nextInt();
    //    System.out.println("请输入数字2：");
    //    int num2 = scanner.nextInt();
    //    MathOperation mathOperation = null;
    //    if (className.equals("Add")){
    //        mathOperation = new Add();
    //    }else if(className.equals("Decument")){
    //        mathOperation = new Decument();
    //    }
    //    int result =  mathOperation.operation(num1,num2);
    //    System.out.println("结果为："+result);
    //}

    //利用反射实现非常的灵活，只需要传入类名，s不需要判断
    //我们只要指定[指定的包下的指定的q类去初始化就行了]
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入计算类名： ");
        String className = scanner.next();
        System.out.println("请输入数字1：");
        int num1 = scanner.nextInt();
        System.out.println("请输入数字2：");
        int num2 = scanner.nextInt();
        MathOperation mathOperation = null;
        try {
            mathOperation= (MathOperation) Class.forName("example."+className).newInstance();
            //mathOperation= (MathOperation) Class.forName(className).newInstance();
        }catch (Exception e){
            System.out.println("类不存在");
        }
        int result =  mathOperation.operation(num1,num2);
        System.out.println("结果为："+result);
    }
}
