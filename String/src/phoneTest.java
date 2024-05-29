import java.util.ArrayList;


public class phoneTest {
    public static void main(String[] args) {
        ArrayList<Phoen> list = new ArrayList<>();
        Phoen p1 = new Phoen("小米", 1299);
        Phoen p2 = new Phoen("华为", 299);
        Phoen p3 = new Phoen("Vivo", 199);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ArrayList<Phoen> result = FindPhonePrice(list);
        for (int i = 0; i < result.size(); i++) {
            Phoen p = result.get(i);
            System.out.println(p.getPhoneBrand() + p.getPhonePrice());
        }
    }

    public static ArrayList<Phoen> FindPhonePrice(ArrayList<Phoen> list) {
//        创建一个类
        ArrayList<Phoen> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Phoen p = list.get(i);
            int price = p.getPhonePrice();
            if (price < 300) {
//                System.out.println(price);
                result.add(p);
            }
        }
        return result;
    }
}
