import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main  (String[] args) {
        // 创建一个Comparator来告诉TreeMap如何比较Student对象

//       练习题：
//        需求 key存储学生对象
//             value 存储籍贯
//        要求按照 学生的年龄去排序 年龄一样按照名字字母排序 不能重复

//        创建学生对象：
        //       创建map集合

        TreeMap<Student, String> map = new TreeMap<>();

        Student s1 = new Student("张三", 20);
        Student s2 =new Student("李四", 24);
        Student s3 = new Student("王五", 26);
        Student s4 = new Student("王五", 26);


//        添加数据并测试是否会重复
        map.put(s1, "河北");
        map.put(s2, "辽宁");
        map.put(s3, "山西");
        map.put(s4, "河南");

//        System.out.println(map);
//        遍历TreeMap


        for (Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue()+""+entry.getKey().getAge());
        }
    }
}