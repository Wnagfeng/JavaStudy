public class singlettwo {
    //单例模式【饱汉模式】
    //时间换空间模式
    private static singlettwo instance = null;
    private singlettwo() {}
    //创建开放的静态方法，返回单例对象
    public static singlettwo getInstance() {
        //特点就是只有第一次调用初始化的时候才会创建对象，后面都直接返回这个对象
        if (instance == null) {
            instance = new singlettwo();
        }
        return instance;
    }

}
