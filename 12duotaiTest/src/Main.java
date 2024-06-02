public class Main {
    public static void main(String[] args) {
        Persong p1=new Persong("wangfeng","18");
        Persong p2=new Persong("Joon","19");
        Dog D=new Dog("3","黑色");
        Cat C =new Cat("2","白色");
        p1.keepPet(D,"骨头");
        p1.keepPet(C,"鱼");
        System.out.println("Hello world!");
    }
}