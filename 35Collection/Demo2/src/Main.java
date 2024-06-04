import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        cllection集合的遍历方式

        Collection<String> list = new ArrayList<>();


        list.add("hello");
        list.add("world");
        list.add("java");
//        1.使用for-each遍历(使用增强for遍历)
//        for (String str : list) {
//            System.out.println(str);
//        }
        // 2.使用Iterator遍历(迭代器模式)
//        首先我们需要获取到Iterator对象，然后通过hasNext()方法判断是否还有下一个元素，如果有，则通过next()方法获取下一个元素，否则抛出NoSuchElementException异常。


        /*
        * ListIterator<String> iterator = list.listIterator();:
        * 这一行创建了一个ListIterator对象，并将其初始化为指向列表list的第一个元素之前（在第一个元素之前的位置）
        * iterator.hasNext();: 这是一个循环的条件，它检查迭代器是否还有下一个元素。只要列表中还有元素未被遍历，循环就会继续执行。
        * iterator是获取第一个参数 就是js中的let i=0
        * iterator.hasNext(); 就是js中的i<arr.length 从第一个元素开始往下找
         * */
//        for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext(); ) {
//            String str = iterator.next();
//            System.out.println(str);
//        }

        list.forEach((str)-> System.out.println(str));



    }
}