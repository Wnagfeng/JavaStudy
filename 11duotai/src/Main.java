public class Main {
    public static void main(String[] args) {
        Dog d1=new Dog("9","黑色");
        Cat c1=new Cat("8","白色");
        Persong p =new Persong("wangfeng","19");
        p.keepPet(c1,"鱼");
        System.out.println("--------------------------");
        p.keepPet(d1,"骨头");
    }
}