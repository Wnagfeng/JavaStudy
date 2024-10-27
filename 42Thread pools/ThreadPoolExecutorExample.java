import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        // 创建 ThreadPoolExecutor
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 核心线程数
                4, // 最大线程数
                60, // 存活时间
                TimeUnit.SECONDS, // 时间单位
                new java.util.concurrent.ArrayBlockingQueue<>(10), // ArrayBlockingQueue 是一个有界的阻塞队列，它的容量在创建时指定（此例中为 10），即最多能存放 10 个任务
                new ThreadPoolExecutor.CallerRunsPolicy() // 使当线程池无法接收新的任务时，将如何处理被拒绝的任务。
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("正在执行任务: " + taskId);
                try {
                    // 模拟任务执行
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("任务完成: " + taskId);
            });
        }

        // 关闭线程池
        executor.shutdown();
        try {
            // 等待所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // 超时则强制关闭
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("所有任务已完成.");
    }
}
