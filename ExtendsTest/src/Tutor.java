// Tutor 类
public class Tutor extends Teacher {
    public Tutor(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is tutoring students.");
    }
}