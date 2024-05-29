public class Dog extends Animal{
    public Dog(String age, String color) {
        super(age, color);
    }

    public Dog() {
    }

    @Override
    public void eat(String something) {
        System.out.print("我是一条狗我今年"+getAge()+"我的颜色是"+getColor()+"我喜欢吃"+something);
    }
    public void LookHome(){
        System.out.print("狗看家");
    }
}
