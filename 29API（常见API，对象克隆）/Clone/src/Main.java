//public class Main {
//    public static void main(String[] args) {
////        对象的clone方法
//        Person person = new Person("Tom", 20);
//        try {
//            Person clonePerson = (Person) person.clone();
//            System.out.println(clonePerson.getName());
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//    }
//}
////

public class Main {
    public static void main(String[] args) {
        // 创建一个 Person 对象
        Person person = new Person("Tom", 20);

        // 克隆 Person 对象
        try {
            Person clonePerson = person.clone();

            // 打印原始对象和克隆对象的信息
            System.out.println("原始对象:");
            person.printPerson();

            System.out.println("克隆对象:");
            clonePerson.printPerson();

            // 修改克隆对象的信息
            clonePerson.setName("Jerry");
            clonePerson.setAge(25);

            // 打印修改后的克隆对象和原始对象的信息
            System.out.println("修改后的克隆对象:");
            clonePerson.printPerson();

            System.out.println("原始对象保持不变:");
            person.printPerson();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
