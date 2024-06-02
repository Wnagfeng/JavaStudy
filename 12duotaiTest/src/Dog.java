public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String age, String color) {
        super(age, color);
    }


    public  void eat(String something){
        System.out.println(getAge()+"的"+getColor()+"的狗两只前腿死死的抱住骨头猛吃");
    }
    public  void catchMouse(){

    }
}
