public class Student {
    private String id;
    private String name;
    private String address;
    private int age;
   static   String nn = "1234";


    public Student() {
    }

    public Student(String id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;

    }

    public static   void showinfo() {
        System.out.println(nn);
//        this.showinfo2();
    }

    public void showinfo2() {
        System.out.println(this.name);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
