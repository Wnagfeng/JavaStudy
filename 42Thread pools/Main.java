// 通过实现Runnable接口，创建的多线程管理起来是非常麻烦的！创建多个线程还会导致死机、资源浪费等问题。
// 所以在java种我们建议你使用线程池来管理线程，线程池可以自动管理线程，并提供线程复用，提高程序的效率。

/*
* 创建线程池的四种方式:
* 1. Executors.newFixedThreadPool(int nThreads): 创建固定大小的线程池，线程池中的线程数量始终保持不变。
* 2. Executors.newCachedThreadPool(): 创建一个可缓存的线程池，线程池中的线程数量不固定，可以根据需要自动调整线程数量。
* 3. Executors.newSingleThreadExecutor(): 创建一个单线程的线程池，线程池中只包含一个线程，任务按顺序执行。
* 4. Executors.newScheduledThreadPool(int corePoolSize): 创建一个定长线程池，支持定时以及周期性执行任务。
* */
public class Main {
    public static void main(String[] args) {

    }
}
