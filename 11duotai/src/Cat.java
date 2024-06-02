public class Cat extends Animal {

    public Cat(String age, String color) {
        super(age, color);
    }

    public Cat() {
    }

    public void eat(String something) {
        System.out.print("我是一只猫我今年"+getAge()+"我的颜色是"+getColor()+"我喜欢吃"+something);
    }
    public void catMouse(){
        System.out.println("猫捉老鼠");
    }
}
