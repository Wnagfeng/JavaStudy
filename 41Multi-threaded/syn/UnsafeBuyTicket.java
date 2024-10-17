package syn;
//不安全的抢票示例：
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        //    创建三个人抢票
        BuyTickett by= new BuyTickett();
        Thread T1= new Thread(by,"张三");
        Thread T2= new Thread(by,"王五");
        Thread T3 =new Thread(by,"李四");
                //启动线程
        T1.start();
        T2.start();
        T3.start();
    }
}

//模拟多线程并发抢票
class  BuyTickett implements  Runnable{
    private int ticketNum=10;
    private boolean flag=true;
    public void BuyTickett(){
        if(ticketNum<=0){
            flag=false;
            return;
        }
        //模拟延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"买到的票："+ticketNum--);
    }
    @Override
    public synchronized void run() {
        while (flag){
            BuyTickett();
        }
    }
}