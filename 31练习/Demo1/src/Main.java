public class Main {
    public static void main(String[] args) {
          /*
            自己实现parseInt方法的效果，将字符串形式的数据转成整数。要求:
            字符串中只能是数字不能有其他字符最少一位，最多10位，0不能开头

            使用正则
        */

        String str = "1234567890";
        if (!str.matches("[1-9]\\d{0,9}")) {
            //错误的数据
            System.out.println("数据格式有误");
        } else {
            //正确的数据
            System.out.println("数据格式正确");
            //3.定义一个变量表示最终的结果
            int number = 0;
            //4.遍历字符串得到里面的每一个字符
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - '0';//把每一位数字放到number当中
                number = number * 10 + c;
            }
            System.out.println(number);
            System.out.println(number + 1);
        }

    }
}