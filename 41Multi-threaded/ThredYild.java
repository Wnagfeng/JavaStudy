public class ThredYild implements Runnable{
    //礼让线程不一定成功，因为线程调度是由操作系统决定的，并不是由程序员决定的
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行!");
        Thread.yield();//礼让!
        System.out.println(Thread.currentThread().getName()+"线程执行结束!");
    }

    public static void main(String[] args) {
        ThredYild t = new   ThredYild();
        Thread t1 = new Thread(t,"a");
        Thread t2 = new Thread(t,"b");
        t1.start();
        t2.start();
    }
}
