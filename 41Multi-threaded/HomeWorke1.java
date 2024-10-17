public class HomeWorke1 implements Runnable {
    // 胜利者标志
    private boolean win = false;

    private boolean isWin(int i) {
        if (i >= 100) {
            win = true;
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 检查胜利状态
            if (win) {
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + " 正在努力中..." + i);

                // 控制线程1不至于太快完成
                if (Thread.currentThread().getName().equals("线程1") && i ==90) {
                    // 让线程1在90步之前就停止
                    try {
                        Thread.sleep(100); // 更长时间，让线程2能够胜出
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 检查是否胜利
                if (isWin(i)) {
                    // 仅在达标时打印胜利者
                    System.out.println("胜利者！" + Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        HomeWorke1 hw1 = new HomeWorke1();
        Thread t1 = new Thread(hw1, "线程1");
        Thread t2 = new Thread(hw1, "线程2");
        t1.start();
        t2.start();
        System.out.println("Hello World");
    }
}
