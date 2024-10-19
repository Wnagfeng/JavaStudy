import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 创建定长线程池
/*
* 定长线程池：
* 线程池的大小一旦确定，就不会再改变，除非主动调用线程池的shutdown()方法。
* 所有任务都将按照先入先出的顺序执行，并且当线程池的容量达到上限时，新任务将被阻塞。
* 定长线程池的特点是固定线程总数，空闲的线程用于执行任务，如果线程都在使用，后续任务则处于等待状态
* */
public class Fixed {
    //一、创建定长线程池[不需要返回值的用法(execute)]
    //public static void main(String[] args) {
    //    int nThreads = 3;//1.创建定长线程池
    //    ExecutorService executor = Executors.newFixedThreadPool(nThreads);//2.创建线程池
    //    for (int i = 0; i < 10; i++) {
    //        int finalI = i;// 用final修饰变量i，避免线程安全问题
    //        executor.execute(new Runnable() {//3.创建任务,并使用execute来执行线程
    //            @Override
    //            public void run() {
    //                System.out.println(Thread.currentThread().getName() + " is running"+ finalI);
    //            }
    //        });
    //    }
    //    // 4.关闭线程池
    //    executor.shutdown();
    //}
    //二、创建定长线程池[需要返回值的用法(submit)]
    public static void main(String[] args) {
        int nThreads = 3; // 创建定长线程池
        ExecutorService executor = Executors.newFixedThreadPool(nThreads); // 创建线程池
        List<Future<Integer>> futures = new ArrayList<>(); // 用于保存每个任务的返回结果

        for (int i = 0; i < 10; i++) {
            final int finalI = i; // 用final修饰变量i，避免线程安全问题
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    // 模拟一些计算任务，例如返回索引的平方
                    return finalI * finalI;
                }
            });
            futures.add(future); // 将Future对象添加到列表中
        }

        // 处理每个任务的结果
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get(); // 获取任务的返回值
                System.out.println("返回值: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executor.shutdown();
    }
}
