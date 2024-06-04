public class Main {
    public static void main(String[] args) {
        int peach = 1; // 第10天的桃子数量
        for (int i = 9; i >= 1; i--) {
            peach = (peach + 1) * 2;
        }
        System.out.println("最初总共有 " + peach + " 个桃子。");
    }
}
