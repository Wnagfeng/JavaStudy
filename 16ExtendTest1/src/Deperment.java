public class Deperment {
    private String name;
    private String age;
    private  static  String nnaammee="xxx";

    public  void showClassTable(){
        System.out.println("我能查看课表");
    }

    public Deperment() {
    }

    public Deperment(String name, String age) {
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
}
