public class Threaddaemon {

    public static void main(String[] args) {
        Thread GODThread = new Thread(new God());
        Thread YOUThread = new Thread(new you());
        GODThread.setDaemon(true);//默认是false，设置为守护线程需要设置为true
        GODThread.start();
        YOUThread.start();//用户线程启动
        //    当用户线程结束以后守护线程还会等待一会就会结束了,因为java虚拟机不用等待守护线程结束，所以守护线程可以实现一些后台的功能
    }
}
class God implements  Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("神说：我保护你！");
        }
    }
}

class you implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你好，世界！");
        }
        System.out.println("拜拜，世界！");
    }
}
