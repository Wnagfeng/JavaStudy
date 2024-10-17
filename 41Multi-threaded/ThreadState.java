public class ThreadState implements Runnable {
    @Override
    public void run() {
        try {
            // 进入 RUNNABLE 状态
            Thread.sleep(1000); // Simulate work

            // 进入 WAITING 状态
            synchronized (this) {
                wait(); //当前线程进入WAITING状态
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
        Thread t = new Thread(threadState); // 实例化线程

        // 输出线程状态：NEW
        System.out.println("Thread state after creation: " + t.getState());

        t.start(); // 启动线程

        // 输出线程状态：RUNNABLE
        System.out.println("Thread state after start: " + t.getState());

        Thread.sleep(1500); // 等待一段时间以进入 WAITING 状态
        System.out.println("Thread state after sleep: " + t.getState());

        // 唤醒线程并使其终止
        synchronized (threadState) {
            threadState.notify(); // 唤醒线程
        }

        t.join(); // 确保线程执行完毕

        // 输出线程状态：TERMINATED
        System.out.println("Thread state after completion: " + t.getState());
    }
}
