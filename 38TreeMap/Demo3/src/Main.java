import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        统计字符串出现的次数(Treemap) 需要排序 存储字符的编码
        String str = "h e l l o w o r l d h e l l o w o r l d";
        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
//                按照字符的编码排序
                return 0;
            }
        });

        String[] words = str.split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }



    }
}