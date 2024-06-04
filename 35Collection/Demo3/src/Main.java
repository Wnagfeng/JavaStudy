import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        演示list遍历方式
        List<String> list = new ArrayList<>();  // 创建一个List集合
        list.add("hello");
        list.add("world");
//        for (String s : list) {
//            System.out.println(s);
//        }

//        列表迭代器
//        他在迭代器遍历中额外添加了方法可以添加元素，删除元素，替换元素等操作
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
//            演示添加元素
            if (iterator.nextIndex() == 1) {
                iterator.add("java");
            }
////            演示删除元素
//            if (iterator.nextIndex() == 2) {
//                iterator.remove();
//            }
////            演示替换元素
//            if (iterator.nextIndex() == 3) {
//                iterator.set("java");
//            }


            System.out.println(iterator.next());
        }
        System.out.println(list);
    }
}