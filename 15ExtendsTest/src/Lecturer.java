// Lecturer 类
public class Lecturer extends Teacher {
    public Lecturer(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is giving a lecture.");
    }
}
