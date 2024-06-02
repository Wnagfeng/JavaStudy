import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
//        定义一个方法将原数组中的指定长度的元素拷贝到 新数组中并且进行返回
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        int res[] = copyOf(array, 6);
        System.out.println("您的数组为：" + Arrays.toString(res));

    }

    public static int[] copyOf(int[] arr, int newLength) {
        return Arrays.copyOf(arr, newLength);
    }
}
