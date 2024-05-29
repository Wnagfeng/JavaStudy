// AdminStaff 类
public class AdminStaff extends Employee {
    public AdminStaff(String id, String name) {
        super(id, name, "Administrative work");
    }

    @Override
//    Override 是 Java 关键字，用来重写父类的方法。
    public void work() {
        System.out.println(getName() + " is handling administrative affairs.");
    }


}