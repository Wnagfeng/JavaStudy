public class ImpRunnable implements Runnable {

    private int i;

    @Override
    public  void run() {
        for(;i < 50;i++) {
            //当线程类实现Runnable接口时，要获取当前线程对象只有通过Thread.currentThread()获取
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for(int j = 0;j < 30;j++) {
            System.out.println(Thread.currentThread().getName() + " " + j);
            if(j == 10) {
                ImpRunnable thread_target = new ImpRunnable();
                //通过new Thread(target,name)的方式创建线程
                new Thread(thread_target,"线程1").start();
                new Thread(thread_target,"线程2").start();
            }

        }

    }

}