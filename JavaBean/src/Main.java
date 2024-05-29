public class Main {
    public static void main(String[] args) {
//        初始化user类
        User user1 = new User("wangfeng", "123456", "2712442320@qq.com", "man", 19);

        String name = user1.getUsername();
        String Emal = user1.getEmail();
        String password = user1.getPassword();
        String gender = user1.getGender();
        int age = user1.getAge();
        System.out.println("我的名字是" + name + "我的邮箱是" + Emal + "我的密码是" + password + "我的性别是" + gender + "我的年龄是" + age);
    }
}