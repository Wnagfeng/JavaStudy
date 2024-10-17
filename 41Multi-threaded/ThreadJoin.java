public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " running " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin,"VIPTHREAD");


        for (int i = 0; i < 1000; i++) {
            if(i==200){
                thread.start();
                thread.join();
                System.out.println("VIP Thread has joined");
            }
            System.out.println("Main Thread running " + i);
        }
    }
}
