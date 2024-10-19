import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Single {
    //Executors.newSingleThreadExecutor(): 创建一个单线程的线程池，线程池中只包含一个线程，任务按顺序执行。
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // 创建线程池
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running"+ finalI);
                }
            });
        }
        executor.shutdown(); // 关闭线程池
    }
}
