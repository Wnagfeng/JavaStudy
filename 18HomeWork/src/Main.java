public class Main {
    public static void main(String[] args) {
//        定义一个方法替换数组中的元素
        System.out.println("Hello world!");
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        fill(array, 0, 6, 0);
        PrintArray(array);
    }

    public static void fill(int[] arr, int fromIndex, int toIndex, int value) {
        for (int i = fromIndex; i < toIndex; i++) {
            arr[i] = value;
        }
    }

    public static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }
}