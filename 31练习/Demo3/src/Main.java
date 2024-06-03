public class Main {
    public static void main(String[] args) {
//        自己实现一个toBinaryString()方法，将一个整数转换为二进制字符串
        int num = 6;
        String binaryString = "";
        while (num > 0) {
            int remainder = num % 2;
            binaryString = remainder + binaryString;
            num /= 2;
        }
        System.out.println(binaryString);
    }

}