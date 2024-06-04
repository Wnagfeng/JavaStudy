public class Main {
    public static void main(String[] args) {
        int firstMonth = 1;
        int secondMonth = 1;
        int totalPairs = 0;

        for (int i = 3; i <= 12; i++) {
            totalPairs = firstMonth + secondMonth;
            firstMonth = secondMonth;
            secondMonth = totalPairs;
        }

        System.out.println("第十二个月总共有 " + totalPairs + " 对兔子。");
    }
}
