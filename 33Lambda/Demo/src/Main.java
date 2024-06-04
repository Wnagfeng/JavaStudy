import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        利用 arrays中的sort方法对数组进行排序
        String[] arr = {"a","aaaa","aa","aaa","aaaaa"};
//        Arrays.sort(arr,new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
//        lambda表达式
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());


        System.out.println(Arrays.toString(arr));
    }
}