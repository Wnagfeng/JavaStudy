public class Team {
    public static void main(String[] args) {
        // 一开始 没有乘客
        int count = 0;
        // 第一站：上去一位乘客
        count = count + 1;
        // 第二站：上去两位乘客，下来一位乘客
        count = count + 2 - 1;
        // 第三站：上去两位乘客，下来一位乘客
        count = count + 2 - 1;
        // 第四站：下来一位乘客
        count = count - 1;
        // 第五站：上去一位乘客
        count = count + 1;
        System.out.println("最终乘客为:" + count);
    }

}