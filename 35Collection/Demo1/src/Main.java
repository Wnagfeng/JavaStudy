import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Collection是Java集合框架的顶层接口，它提供了对集合对象进行基本操作的通用接口。
        List<String> list = new ArrayList<>();  // 创建一个List集合对象
        list.add("Hello");   // 添加元素
        list.add("World");


        System.out.println(list);   // 输出集合元素

        System.out.println(list.size());   // 输出集合大小

        list.remove(0);   // 删除集合中的第一个元素

        System.out.println(list);   // 输出集合元素

        list.clear();   // 清空集合
    }
}