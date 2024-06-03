public class Demo {
    public static void main(String[] args) {
        // 自幂数：
        // 统计1-999有多少水仙花数。

        // 水仙花数是指一个 3 位数，其各位数字的立方和等于该数本身。
        // 例如：153 = 1^3 + 5^3 + 3^3。

        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = (i - a * 100) / 10;
            int c = i - a * 100 - b * 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);
            }
        }
    }
}
