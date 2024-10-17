public class ThreadSleep implements Runnable {
    //Sleep 需要做一个异常捕获
    //模拟倒计时
    @Override
    public void run() {

    }
    public  static void  TenDown(){
        int i=10;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(i--);
                if(i==0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TenDown();
    }
}
