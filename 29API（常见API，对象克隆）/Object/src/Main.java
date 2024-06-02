public class Main {
    public static void main(String[] args) {
//        toString() 方法
//        判断对象是否相等
//        对象克隆
        
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1.equals(obj2)); // false
        System.out.println(obj1);

//        演示对象克隆
//        Object obj3 = obj2.clone();
//        System.out.println(obj3);


        /*
        * 关于equals()方法的使用
        * equals()方法用来判断两个对象是否相等，如果两个对象相等，则返回true，否则返回false。
        * equals()方法的默认实现是比较两个对象的内存地址是否相同，如果两个对象内存地址相同，则认为它们相等。
        * 一般情况下，我们需要重写equals()方法，以实现自定义的相等判断逻辑。
        * equals()方法的常见重写方法：
        * */
        
        System.out.println("Hello world!");
    }
}