public class Persong {
    private String name;
    private String age;

    public Persong(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Persong() {
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
//    public  void  keepPet(Dog dog,String something){
//        System.out.print("我是"+name+"我今年"+age+"这是我的宠物:");
//        dog.eat(something);
//        System.out.print("我是"+name+"家的狗,我是功能是");
//        dog.LookHome();
//    }
//    public  void  keepPet(Cat cat,String something){
//        System.out.print("我是"+name+"我今年"+age+"这是我的宠物:");
//        cat.eat(something);
//        System.out.print("我是"+name+"家的猫,我是功能是");
//        cat.catMouse();
//    }

    public  void  keepPet(Animal a,String something){
        System.out.print("我是"+name+"我今年"+age+"这是我的宠物:");

        System.out.print("我是"+name+"家的猫,我是功能是");
//        a.catMouse();
        if (a instanceof Dog){
            Dog d = (Dog) a; d.LookHome(); d.eat(something);
        } else if (a instanceof Cat){
            Cat c = (Cat) a; c.catMouse(); c.eat(something);
        }
    }
}
