import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        创建一个treemap对象用来存储键值对
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "apple");
        map.put(3, "banana");
        map.put(2, "orange");
        map.put(4, "grape");
//        System.out.println("TreeMap: " + map);
//        遍历

//        for (Integer key : map.keySet()) {
//            System.out.println(key + " : " + map.get(key));
//        }


        TreeMap<Integer, String> map1 = new TreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
//                降序排序
                return o2 - o1;
            }
        });
        map1.put(1, "apple");
        map1.put(3, "banana");
        map1.put(2, "orange");
        map1.put(4, "grape");

        System.out.println("TreeMap: " + map1);

    }
}