import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res[] = copyOfRange(array, 0, 5);
        System.out.println("您的数组为："+Arrays.toString(res));

    }

    //    定义一个方法把数组中的元素根据指定的范围拷贝到一个新数组中 并把新数组返回
    public static int[] copyOfRange(int[] arr, int from, int to) {
        return Arrays.copyOfRange(arr, from, to);


    }

}
