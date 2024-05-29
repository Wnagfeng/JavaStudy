// Maintainer 类
public class Maintainer extends AdminStaff {
    public Maintainer(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is maintaining equipment.");
    }
}
