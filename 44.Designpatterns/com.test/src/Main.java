public class Main {
    public static void main(String[] args) {
        //测试单例模式【饿汉模式】
        Singletone s1 = Singletone.getInstance();
        Singletone s2 = Singletone.getInstance();
        if (s1 == s2) {
            System.out.println("s1和s2是同一个实例");
        } else {
            System.out.println("s1和s2不是同一个实例");
        }
        //测试单例模式【懒汉模式】
        singlettwo s3 = singlettwo.getInstance();
        singlettwo s4 = singlettwo.getInstance();
        if (s3 == s4) {
            System.out.println("s3和s4是同一个实例");
        } else {
            System.out.println("s3和s4不是同一个实例");
        }
        System.out.println("Hello world!");

    }
}