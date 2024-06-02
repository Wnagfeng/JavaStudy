public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("001", "John", "general work");
        employee.work();

        System.out.println("--------------------");

        Teacher teacher = new Teacher("002", "Alice");
        teacher.work();

        System.out.println("--------------------");

        AdminStaff adminStaff = new AdminStaff("003", "Tom");
        adminStaff.work();

        System.out.println("--------------------");

        Lecturer lecturer = new Lecturer("004", "Bob");
        lecturer.work();

        System.out.println("--------------------");

        Tutor tutor = new Tutor("005", "Anna");
        tutor.work();

        System.out.println("--------------------");

        Maintainer maintainer = new Maintainer("006", "Jack");
        maintainer.work();

        System.out.println("--------------------");

        Buyer buyer = new Buyer("007", "Eva");
        buyer.work();
    }
}