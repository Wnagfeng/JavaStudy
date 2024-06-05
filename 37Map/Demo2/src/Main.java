import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //        某班级有八十名学生 现在需要组织秋游活动 班长提供了ABCD四个景点 每个学生只能选一个景点
//        请统计出 最终那个景点 想去的人数对多

//        1. 班长提供的四个景点分别是：湖泊、森林、山峰、海滩
//        2. 八十名学生的选择如下：
//            学生A：山峰
//            学生B：海滩

        String[] places = {"湖泊", "森林", "山峰", "海滩"};
        ArrayList<String> list =new  ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < 999999; i++) {
            int index = random.nextInt(places.length);
            list.add(places[index]);
        }
        Map<String, Integer> map = new HashMap<>();
//        遍历list，统计每个景点的选票数
        for (String place : list) {
            if (map.containsKey(place)) {
//                如果存在就加1
//                map.get(place)
                map.put(place, map.get(place) + 1);
            } else {
//                不存在就添加
                map.put(place, 1);
            }
        }
        System.out.println(map);
//        统计选票数最多的景点
        int max = 0;
        String maxPlace = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxPlace = entry.getKey();
            }


    }
        System.out.println("最终选择的景点：" + maxPlace + " 想去的人数：" + max);
        }





}
