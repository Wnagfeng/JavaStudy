package syn;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        TetsLock tetsLock = new TetsLock();
        Thread t1 = new Thread(tetsLock,"t1");
        Thread t2 = new Thread(tetsLock,"t2");
        Thread t3 = new Thread(tetsLock,"t3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class  TetsLock implements  Runnable{
    int count =10;
    private ReentrantLock lock = new ReentrantLock();
   void decrment(){
       while(true){
           lock.lock();
           try {
               if(count<=0){
                   break;
               }
               System.out.println(Thread.currentThread().getName() + " is running"+count--);
           }finally {
               lock.unlock();
           }

           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }


       }
   }

    @Override
    public void run() {
        decrment();
    }
}