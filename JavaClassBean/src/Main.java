public class User {
    //    创建一个类用于表示一个网站登录的用户信息
    private String UserName;
    private String PassWord;
    private String Emal;
    private String Gender;
    private int age;

    //    空参方法
    public User() {
    }
//    带参数的构造函数


    public User(String userName, String passWord, String emal, String gender, int age) {
        this.UserName = userName;
        this.PassWord = passWord;
        this.Emal = emal;
        this.Gender = gender;
        this.age = age;
    }
}
