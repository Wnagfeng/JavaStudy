public class sheep extends Animal{

    public sheep(String name, String age) {
        super(name, age);
    }

    @Override
    public void eta() {
        System.out.println("🐏吃草");
    }
}
