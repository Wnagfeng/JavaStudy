public class Dog extends Animal{

    public Dog(String name, String age) {
        super(name, age);
    }

    @Override

    public void eta() {
        System.out.println("🐕吃骨头");
    }
}
