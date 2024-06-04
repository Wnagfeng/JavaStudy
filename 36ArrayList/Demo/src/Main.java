import java.util.ArrayList;
class ye { }
class fu extends ye{ }
class zi extends fu{ }
public class Main {
    public static void main(String[] args) {

//        创建四个集合类型
        ArrayList<ye> list1 = new ArrayList<>();
        ArrayList<fu> list2 = new ArrayList<>();
        ArrayList<zi> list3 = new ArrayList<>();
        addarray(list1);

        addarray(list2);
//
        addarray(list3);
    }
//    ? extends ye 代表该集合只能存放ye及其子类的对象
//    ? super ye 代表该集合只能存放ye及其父类的对象
public static void  addarray(ArrayList<? extends   ye> list){

    }

}