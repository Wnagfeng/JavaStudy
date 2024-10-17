public class ThreadPriority implements Runnable {
    //在 Java 中，虽然线程有优先级的设置，
    // 但是操作系统的线程调度并不一定会按照线程的优先级顺序来调度执行。
    // 这是因为线程调度是由操作系统底层的线程管理机制控制的，
    // 而 Java 只是在其上提供了一种机制来设置线程的优先级。
    // 实际上，线程调度的行为可以受到许多因素的影响
    private String threadName;

    public ThreadPriority(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " (优先级: " + Thread.currentThread().getPriority() + ") 运行 " );
        // 让 CPU 有机会切换到其他线程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPriority lowPriorityTask = new ThreadPriority("低优先级线程");
        ThreadPriority normalPriorityTask = new ThreadPriority("普通优先级线程");
        ThreadPriority highPriorityTask = new ThreadPriority("高优先级线程");

        Thread lowPriorityThread = new Thread(lowPriorityTask);
        Thread normalPriorityThread = new Thread(normalPriorityTask);
        Thread highPriorityThread = new Thread(highPriorityTask);

        // 设置线程优先级
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // 1
        normalPriorityThread.setPriority(Thread.NORM_PRIORITY); // 5
        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10

        // 启动线程
        lowPriorityThread.start();
        normalPriorityThread.start();
        highPriorityThread.start();
    }
}
