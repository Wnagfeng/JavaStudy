import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段文字");
        String result=sc.next();
        int Length = result.length();
        for (int i = 0; i < Length; i++) {
            char c = result.charAt(i);
            System.out.println(c);
        }
    }
}