import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        退出虚拟机
//        System.exit(0);
//        状态码0表示正常退出，非0表示异常退出
//        System.out.println("Hello world!");

//        拷贝数组

        int[] arr1 = {1, 2, 3, 4, 5};

        int[] arr2 = new int[arr1.length];

       System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println(Arrays.toString(arr2));
        
    }
}