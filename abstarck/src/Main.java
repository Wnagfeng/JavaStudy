public class Main {
    public static void main(String[] args) {
        Dog D=new Dog("小黑","9");
        forg F=new forg("小白","7");
        sheep s=new sheep("小红","6");
        s.eta();
        s.drink();
        D.eta();
        D.drink();
        System.out.println("Hello world!");
    }
}