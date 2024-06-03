public class Main {
    public static void main(String[] args) {
        // 创建一个 Address 对象
        Address address = new Address("New York", "5th Avenue");

        // 创建一个 Person 对象
        Person person = new Person("Tom", 20, address);

        // 深拷贝 Person 对象
        Person clonePerson = person.deepClone();

        // 打印原始对象和克隆对象的信息
        System.out.println("原始对象:");
        person.printPerson();

        System.out.println("克隆对象:");
        clonePerson.printPerson();

        // 修改克隆对象的信息
        clonePerson.setName("Jerry");
        clonePerson.setAge(25);
        clonePerson.getAddress().setCity("Los Angeles");
        clonePerson.getAddress().setStreet("Sunset Boulevard");

        // 打印修改后的克隆对象和原始对象的信息
        System.out.println("修改后的克隆对象:");
        clonePerson.printPerson();

        System.out.println("原始对象保持不变:");
        person.printPerson();
    }
}
