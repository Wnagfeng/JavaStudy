public class Singletone {
    //饿汉模式单例对象
    /*
    * 饿汉模式最大的特点就是在类加载的时候就完成实例化，
    * 其实就是用空间去换时间
    * */
   //1.创建私有的构造函数
    private Singletone() {
    }
    //2.创建静态私有变量
    private static final Singletone instance = new Singletone();
    //3.提供公共的静态方法，返回单例对象
    public static Singletone getInstance() {
        return instance;
    }
}
