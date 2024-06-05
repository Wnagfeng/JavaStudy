import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Map对象练习
//        存储学生对象对象 key是学生 value是学生的籍贯
//        存储三个值 并且进行遍历
//        要求： 同一个姓名 同年龄的学生是一个学生


        Map<Student, String> map = new HashMap<>();
        Student s1 = new Student("张三", 20,234038);
        Student s2 = new Student("李四", 21,208308);
        Student s3 = new Student("王五", 21,347380);
        Student s4 = new Student("王五", 21,347380);

        map.put(s1, "河南");
        map.put(s2, "河北");
        map.put(s3, "山东");
        map.put(s4, "江苏");

//还记得吗 entry就是Map.Entry<K,V> 其中K是key V是value
//       当你重写了map对象的equals和hascode方法后 添加到map中的时候 该对象的所有字段
//       都重复才会被判断为 重复对象
        for (Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getAge() + " " + entry.getValue());
        }

    }
}