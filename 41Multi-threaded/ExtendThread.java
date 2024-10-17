public class ExtendThread extends Thread{
    private  int count;
    @Override
    public void run() {
        for(int i = 0;i < 10;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            count++;
        }
    }

    public static void main(String[] args) {
        for(int j = 0;j < 50;j++) {

            //调用Thread类的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + j);

            if(j == 10) {
                //创建并启动第一个线程
                new ExtendThread().start();

                //创建并启动第二个线程
                new ExtendThread().start();
            }
        }

    }
}
