public class student extends Deperment{
    private  String classname;

    public String getClassname() {
        return classname;
    }

    public student(String classname) {
        this.classname = classname;
    }

    public student(String name, String age, String classname) {
        super(name, age);
        this.classname = classname;
    }

    @Override
    public void showClassTable() {
        System.out.println(getName()+"填写听课反馈"+getClassname());
    }
}
