package syn;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
//    演示不安全的List
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
        new Thread(()->{
            synchronized (list){
                //System.out.println("Thread " + Thread.currentThread().getName());
                list.add(Thread.currentThread().getName());
            }
        }).start();
    }
    try {
        Thread.sleep(1000);
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(list.size());
}
}
