import java.util.Arrays;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
//        抽奖案例  把一个奖池中的数据 随机打印出来且不重复
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        定义一个新数组用于存储抽奖结果
        int[] newArray = new int[array.length];
        Random random = new Random();
        for (int i = 0; i < array.length; ) {
            int randomNumber = random.nextInt(newArray.length);
            int prize = array[randomNumber];
            boolean result = contains(newArray, prize);
            if (!result) {
                newArray[i] = prize;
                i++;
            }
        }
        System.out.println(Arrays.toString(newArray));


    }

    //    定义一个方法去随机的取值 不能重复


    public static boolean contains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

}
