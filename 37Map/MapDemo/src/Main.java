import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        演示Map
//感觉map就是js中的对象
        Map<String, Integer> map = new HashMap<>();
//         向map中添加键值对
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
////         打印map
//        System.out.println(map);
////         访问map中的元素
//        System.out.println(map.get("apple"));
////         修改map中的元素
//        map.put("apple", 50);
//        System.out.println(map.get("apple"));
//
////         删除map中的元素
//        map.remove("banana");
//        System.out.println(map);

//        map的遍历方式(三种)
//        1. 遍历所有的key-value对
//        for (String key : map.keySet()) {
//            System.out.println(key + " : " + map.get(key));
//        }

//        2. 遍历所有的value
//        for (Integer value : map.values()) {
//            System.out.println(value);
//        }

//        3. 遍历所有的key-value对，并对value进行操作(entry表示的就是每一个键值对对象)
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

    }
}