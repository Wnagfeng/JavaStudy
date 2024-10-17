public class ThreadStop implements Runnable {
    //
    private volatile boolean stop = false; // 初始值改为false
    @Override
    public void run() {
        int i = 0;
        while (!stop) { // 条件反转
            i++;
            System.out.println("开启的线程" + i);
        }
    }

    private void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        Thread thread = new Thread(threadStop);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程" + i);
            if (i == 900) {

                threadStop.setStop(true); // 调用设为true，通知线程停止
                System.out.println("停止线程");
            }
        }
    }
}
