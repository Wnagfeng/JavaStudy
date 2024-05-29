public class Buyer extends AdminStaff {
    public Buyer(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is purchasing items.");
    }
}