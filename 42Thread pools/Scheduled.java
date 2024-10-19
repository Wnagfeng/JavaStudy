import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Scheduled {
    //Executors.newScheduledThreadPool(int corePoolSize): 创建一个定长线程池，支持定时以及周期性执行任务。
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    //    延迟一秒执行，每隔三秒打印一次
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("Hello, world!");
            }
        }, 1, 3, java.util.concurrent.TimeUnit.SECONDS);
    }
}
