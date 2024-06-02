public class Persong {
    private String name;
    private String age;

    public Persong(String name, String age) {
        this.name = name;
        this.age = age;
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
    public  void  keepPet(Animal animal,String something){
        if (animal instanceof Dog ){
            Dog d = (Dog) animal;
            System.out.println("年龄为"+getAge()+"岁的"+getName()+"养了一只"+d.getColor()+"的"+getAge()+"岁的狗");
            d.eat(something);
        }else  if (animal instanceof Cat){
            Cat c =(Cat) animal;
            System.out.println("年龄为"+getAge()+"岁的"+getName()+"养了一只"+c.getColor()+"的"+getAge()+"岁的猫");
            c.eat(something);
        }

    }
}
