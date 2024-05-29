public class Teacher  extends  Deperment{
    private  String classname;
    public Teacher() {
    }

    public Teacher(String name, String age,String classname) {
        super(name, age);
        this.classname=classname;
    }

    public String getClassname() {
        return classname;
    }

    @Override
    public void showClassTable() {
        System.out.println(getName()+"发布名称"+getClassname());
    }
}
