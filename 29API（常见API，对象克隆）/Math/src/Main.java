public class Main {
        public static void main(String[] args) {

                // 求绝对值
                int a = -10;
                int b = Math.abs(a);
                System.out.println("The absolute value of " + a + " is " + b);

                // 求最大值
                int c = 10;
                int d = 20;
                int max = Math.max(c, d);
                System.out.println("The maximum value of " + c + " and " + d + " is " + max);

                // 求最小值
                int e = 10;
                int f = 20;
                int min = Math.min(e, f);
                System.out.println("The minimum value of " + e + " and " + f + " is " + min);

                // 进一法
                double g = 3.5;
                double h = Math.ceil(g);
                System.out.println("The ceiling of " + g + " is " + h);

                // 舍去法
                double i = 3.5;
                double j = Math.floor(i);
                System.out.println("The floor of " + i + " is " + j);

                // 四舍五入
                double k = 3.5;
                double l = Math.round(k);
                System.out.println("The rounded value of " + k + " is " + l);

                // 随机数
                int m = (int) (Math.random() * 100);
                System.out.println("A random number between 0 and 100 is " + m);

        }
}