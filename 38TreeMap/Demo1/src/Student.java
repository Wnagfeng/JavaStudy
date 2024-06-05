import java.util.Objects;

public class Student  implements Comparable<Student> {
    private   String name;
    private   int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;


        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o) {
//         要求按照 学生的年龄去排序 年龄一样按照名字字母排序 不能重复
//        this表示当前要添加的元素
//         o表示当前红黑树中以及存在的元素

//        返回值：
//        负数：表示当前元素小于o元素 放到红黑树的左边
//        0：表示当前元素和o元素相等 舍弃
//        正数：表示当前元素大于o元素 放到红黑树的右边

//        compareTo会返回 两个字符串比较的结果  如果是0 则表示两个字符串相等

        int  i= this.getAge() - o.getAge();
        i= i!=0? i : this.getName().compareTo(o.getName());

        return i;
    }
}
