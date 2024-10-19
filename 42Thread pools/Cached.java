import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cached {
    //创建一个可缓存的线程池，线程池中的线程数量不固定，可以根据需要自动调整线程数量。
    // 特点是无限大，如果线程池中没有可用的线程则创建，有空闲的线程则利用。
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();//
        for (int i = 0; i < 30; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " is running");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }
}
