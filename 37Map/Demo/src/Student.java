import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private int schoolnum;

    public Student(String name, int age, int schoolnum) {
        this.name = name;
        this.age = age;
        this.schoolnum = schoolnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSchoolnum() {
        return schoolnum;
    }

    public void setSchoolnum(int schoolnum) {
        this.schoolnum = schoolnum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && schoolnum == student.schoolnum && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, schoolnum);
    }
}
