public class backetBollCoch extends Coach {
    public backetBollCoch(String name, String age) {
        super(name, age);
    }

    public backetBollCoch() {
    }

    @Override
    public void teacher() {
        System.out.println("篮球教练教篮球");
    }
}
