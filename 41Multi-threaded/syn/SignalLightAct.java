package syn;
//本节讲解信号灯法标志位解决方案
// 通过观看节目案例讲解
// 演员表演节目观众观看节目
/// 观众观看节目演员等待表演节目
public class SignalLightAct {
    public static void main(String[] args) {
        TV tv=new TV();
        Observer observer=new Observer(tv);
        Performer performer=new Performer(tv);
        new Thread(observer).start();
        new Thread(performer).start();
    }
}
// TV类
class TV{
    String program;// 表演的节目
    boolean signalLight=true;
    /*
    * signalLight=true --- 演员表演，观众等待
    * signalLight=false --- 观众观看，演员等待
    * */
    //观看节目
    public synchronized void watch() throws InterruptedException {
        if(signalLight){
            wait();
        }
        System.out.println("观众观看了节目: " + program);
        signalLight = true; // 观看完了，设置为true，通知演员去表演
        notifyAll();// 通知所有等待的线程
    }
    //表演节目
    public synchronized void perform(int i) throws InterruptedException {
        if(!signalLight){
            wait();//等待观众观看
        }
        this.program="《卖拐》";
        signalLight = false; // 表演完了，设置为false，通知观众观看
        System.out.println("演员"+i+"表演了"+this.program);
        notifyAll();
    }
}
// 观众类
class Observer implements Runnable{
    TV tv;
    public Observer(TV tv){
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// 表演者类
class Performer implements Runnable{
    TV tv;
    public Performer(TV tv){
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                tv.perform(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
