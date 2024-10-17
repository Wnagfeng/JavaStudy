package syn;
//不安全的取钱系统
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account1 = new Account(1000, "Joon");
        Bank bank1 = new Bank("Syn Bank", "Joon本人", account1, 1000);
        Thread thread1 = new Thread(bank1);
        thread1.start();
        Bank bank2 = new Bank("Syn Bank", "Joon的女友", account1, 1000);
        Thread thread2 = new Thread(bank2);
        thread2.start();

    }
}
//模拟账户
class Account {
    int Blance;//你的余额
    String name;//你的名字
    public Account(int blance, String name) {
        this.Blance = blance;
        this.name = name;
    }
}
//模拟银行取钱操作
class  Bank extends Thread{
    String name;//银行名字
    String yourName;//取钱人的名字
    Account account;//你需要取钱的账户
    int money;//取钱金额
    boolean flag = true;//标记是否还有余额
    public Bank(String name, String yourName, Account account , int money) {
        this.name = name;
        this.yourName = yourName;
        this.account = account;
        this.money = money;
    }
    public void BankMoney(){
        //模拟取钱操作
        if(account.Blance < money){
            System.out.println(name +"对"+yourName+"说"+ "没有足够的钱，请稍后再试");
            flag = false;
        }else{
            account.Blance = account.Blance - money;
            System.out.println(name + "给" + yourName + "取钱" + money + "元成功，"  + "目前账户余额为:" + account.Blance);
            System.out.println(yourName+"取到的钱为："+money);
        }
    }
    @Override
    public  void run() {
        //锁你要明白锁什么东西，我们需要对增删改查的东西进行上锁，比如取钱我们最终改的金额在账户上
        // 所以我们锁住账户
        synchronized (account){
            //模拟取钱操作,并且加上模拟延迟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BankMoney();
        }
    }


}


