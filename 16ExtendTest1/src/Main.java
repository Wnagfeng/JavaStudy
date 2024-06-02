public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        student S1=new student("Joon","19","大一");
        Teacher T1  =new Teacher("wangfeng","22","基础一部");
        S1.showClassTable();
        T1.showClassTable();
    }
}