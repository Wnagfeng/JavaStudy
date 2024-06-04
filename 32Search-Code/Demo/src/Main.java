import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        实现一个基本查找功能
        int[] arr = {5, 2,3,5,6,8, 9,10,11,5};
        System.out.println(binarySearch(arr, 3));
//        查询索引位置
        System.out.println(binarySearchIndex(arr, 5));
//        查询该元素重复的可能性
        System.out.println("重复的可能性： "+binarySearchRepeat(arr, 5)+"%");

//        我需要获取到所有的重复的id
        System.out.println(binarySearchRepeatIndexArray(arr, 5));

    }



    public static boolean binarySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }

        }
        return false;
    }
    public static int binarySearchIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public static int binarySearchRepeat(int[] arr, int target) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                check++;
            }

        }
//        返回重复的可能性百分比
        if(check == 0){
            return 0;
        }
        return (check % arr.length) ;
    }

    public static ArrayList<Integer> binarySearchRepeatIndexArray(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result.add(i);
            }

        }
//        返回重复的可能性百分比
        return result;
    }
}