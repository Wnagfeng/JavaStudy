package CoreClasses;

public class Person {
    static {
        System.out.println("Person static block");
    }

    private String name;
    private int age;
    private String gender;
    public Person() {
        // 无参构造函数
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }



}
