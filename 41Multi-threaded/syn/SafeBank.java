package syn;
//模拟银行取款操作
// 1.需要账户类
//2.需要银行类
public class SafeBank {
    public static void main(String[] args) {
        SafeAccount account = new SafeAccount("张三", 10000);
        SafeBank1 bank =new  SafeBank1 ("中国银行", "张三", 6000, account);
        SafeBank1 bank1 =new  SafeBank1 ("中国银行", "张三女友", 5000, account);
        new  Thread(bank).start();
        new  Thread(bank1).start();

     }
}
class  SafeAccount{
    private String YourName;//持卡人姓名
    int balance;//该卡内的余额

    public SafeAccount(String YourName, int balance) {
        this.YourName = YourName;
        this.balance = balance;
    }
}
class  SafeBank1 implements Runnable{
    private String bankName;//银行名称
    private  String Person;//取款人姓名
    private  int money;//取款金额
      SafeAccount account;//取款账户
    SafeBank1(String bankName, String Person, int money, SafeAccount account) {
        this.bankName = bankName;//银行名称
        this.Person = Person;//取款人姓名
        this.money = money;//取款金额
        this.account = account;//取款账户
    }

    @Override
    public void run() {

        synchronized (account){
            if(this.account.balance < this.money){
                System.out.println(this.bankName + "为" + this.Person + "取款失败！" + this.Person + "账户余额不足！");
                return;
            }
            // 模拟取款操作
            this.account.balance = this.account.balance - this.money;//取款金额
            System.out.println(this.bankName + "为" + this.Person + "取款成功！" + this.Person + "取款金额为：" + this.money + "，账户余额为：" + this.account.balance);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
