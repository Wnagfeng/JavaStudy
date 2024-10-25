package StepFive;

public class Cat {

  private String name;
  private int age;

  public Cat() {
    System.out.println("Cat constructor called");
  }

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }



  public int getAge() {
    return age;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
