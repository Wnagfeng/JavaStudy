public abstract class Animal {
    private String name;
    private String age;

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public abstract void eta();

    public void drink() {
        System.out.println("喝水");
    }
}
