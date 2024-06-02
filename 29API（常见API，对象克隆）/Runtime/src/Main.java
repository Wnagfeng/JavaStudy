public class Main {
    public static void main(String[] args) {
//        获取当前系统运行环境对象
        Runtime runtime = Runtime.getRuntime();
        System.out.println("系统总内存：" + runtime.totalMemory() / 1024 / 1024 + "MB");

        System.out.println("系统剩余内存：" + runtime.freeMemory() / 1024 / 1024 + "MB");

        System.out.println("系统最大内存：" + runtime.maxMemory() / 1024 / 1024 + "MB");
//cpu信息
        System.out.println("CPU数量：" + runtime.availableProcessors());


        System.out.println("Hello world!");
    }
}