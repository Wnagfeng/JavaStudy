import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        打印时间原点一年后的时间总和
        Date data = new Date();
//       获取毫秒数
        long millis = data.getTime();
//       加上一年的毫秒数
        long millisPlusYear = millis + 365 * 24 * 60 * 60 * 1000;

    }
}