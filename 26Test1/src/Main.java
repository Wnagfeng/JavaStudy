import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        测试Cart类
//        创建一个数组去存储三个汽车对象
        Cart[] CartArr = new Cart[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < CartArr.length; i++) {
//            Cart是数据类型
            Cart c = new Cart(); //初始化对象一定要在内部
            System.out.println("请输入"+i+"号汽车的品牌");
            String brand = sc.next();
            c.setCartbrand(brand);
            System.out.println("请输入"+i+"号汽车的颜色");
            String color = sc.next();
            c.setCartcolor(color);
            System.out.println("请输入"+i+"号汽车的价格");
            String price = sc.next();
            c.setCartprice(price);
            CartArr[i] = c;
        }

        for (int i = 0; i < CartArr.length; i++) {
            Cart car = CartArr[i];
            System.out.println("汽车品牌"+car.getCartbrand()+"汽车价格"+car.getCartprice()+"汽车颜色"+car.getCartcolor());

        }
    }
}