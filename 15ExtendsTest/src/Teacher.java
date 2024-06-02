// Teacher 类
public class Teacher extends Employee {
    public Teacher(String id, String name) {
        super(id, name, "Teaching");
    }

    @Override
    public void work() {
        System.out.println(getName() + " is lecturing.");
    }
}