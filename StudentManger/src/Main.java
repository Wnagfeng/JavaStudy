import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentsList = new ArrayList<>();
        ArrayList<Persong> persongList = new ArrayList<>();
        Student Stud = new Student("1", "wangfeng", "安徽省六安市", 19);
        Persong Pers = new Persong("Joon1", "123456", "342423200302174887", "12344556677");
        Persong Pers1 = new Persong("wangfeng1", "124578wf", "342423200302174887", "12344556677");
        studentsList.add(Stud);
        persongList.add(Pers);
        persongList.add(Pers1);

        ShowLoginMessage(persongList, studentsList);


    }

    public static void ShowLoginMessage(ArrayList<Persong> List, ArrayList<Student> list) {
        System.out.println("---------欢迎来到学生管理系统---------");
        System.out.println("---------请先登录或者注册---------");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.忘记密码");
        System.out.println("4.退出");
        System.out.println("请输入您的选择：");
        Scanner sc = new Scanner(System.in);
        String ChooseNumber = sc.next();
        boolean UserState = false;
        loop:
        switch (ChooseNumber) {
            case "1":
                LoginSystem(List, list);
                break;
            case "2":
                Regicatoruser(List);
                break;
            case "3":
                ForGetUserPassord(List);
                break;
            case "4":
                System.out.println("已退出！");
                break loop;
            default:
                System.out.println("没有这个选项！");
                break;
        }
    }


    public static void ShowWelecomeMesage(ArrayList<Student> List) {
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入您的选择：");
        Scanner sc = new Scanner(System.in);
        String ChooseNumber = sc.next();
        loop:
        switch (ChooseNumber) {
            case "1":
                AddStudentInfo(List);
                break;
            case "2":
                DeleteStudentInfo(List);
                break;
            case "3":
                ChangeStudentInfo(List);
                break;
            case "4":
                FindeStudentInfo(List);
                break;
            case "5":
                System.out.println("已退出！");
                break loop;
            default:
                System.out.println("没有这个选项！");
                break;
        }
    }

    public static void LoginSystem(ArrayList<Persong> List, ArrayList<Student> list) {
        while (true) {
            System.out.println("请输入您的账号：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            System.out.println("请输入您的密码：");
            String password = sc.next();
            int index = usernamFindeIndex(List, username);
            if (index != -1) {
                boolean verfyPassword = List.get(index).getPassword().equals(password);
                if (verfyPassword) {
                    System.out.println("尊敬的" + List.get(index).getUsername() + "欢迎您！");
                    ShowWelecomeMesage(list);
                    break;
                } else {
                    System.out.println("您的用户密码错误,请重新输入！");
                }
            } else {
                System.out.println("该用户不存在,请重新输入！");
            }
        }

    }

    public static int usernamFindeIndex(ArrayList<Persong> List, String username) {
        for (int i = 0; i < List.size(); i++) {
            Persong Pers = List.get(i);
            String listId = Pers.getUsername();
            if (listId.equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public static void Regicatoruser(ArrayList<Persong> List) {
        Scanner sc = new Scanner(System.in);
        Persong Psersongtemp = new Persong();
        System.out.println("请输入用户名：");
        String UserName = sc.next();
        boolean StateUsername = VerfyUsername(List, UserName);
        if (!StateUsername) {
            if (UserName.length()<3&&UserName.length()>15){
                System.out.println("用户名长度不够哦");
            }
            System.out.println("当前用户名不存在");
        } else {
            System.out.println("当前用户名已存在请重新输入");
            Regicatoruser(List);
            return;
        }
        System.out.println("当前用户名是否存在" + StateUsername);
        System.out.println("请输入身份证号码：");
        String UserCardID = sc.next();
        System.out.println("请输入您的手机号码：");
        String CellPhone = sc.next();
        System.out.println("请输入您的密码：");
        String Password = sc.next();
        Psersongtemp.setCellPhone(CellPhone);
        Psersongtemp.setPassword(Password);
        Psersongtemp.setCellPhone(CellPhone);
        Psersongtemp.setIdCardNumber(UserCardID);
        Psersongtemp.setUsername(UserName);


    }

    public static boolean VerfyUsername(ArrayList<Persong> List, String name) {
        for (int i = 0; i < List.size(); i++) {
            Persong pers = List.get(i);
            String username = pers.getUsername();
            if (username.equals(name)) {
                return true;
            }
        }
        return false;

    }

    public static void ForGetUserPassord(ArrayList<Persong> List) {

    }

    public static void AddStudentInfo(ArrayList<Student> List) {
        Scanner sc = new Scanner(System.in);
        Student Stud = new Student();
        System.out.println("请输入您要添加的学生信息：");
        while (true) {
            System.out.println("请输入学生ID：");
            String stuID = sc.next();
            boolean Flage = Constain(List, stuID);
            if (Flage) {
                System.out.println("当前ID已存在请重新录入！");
            } else {
                System.out.println("请输入学生姓名：");
                String stuname = sc.next();
                System.out.println("请输入学生年龄：");
                int stuage = sc.nextInt();
                System.out.println("请输入学生地址：");
                String stuaddress = sc.next();
                Stud.setId(stuID);
                Stud.setName(stuname);
                Stud.setAge(stuage);
                Stud.setAddress(stuaddress);
                List.add(Stud);
                System.out.println("学生信息添加成功！");
                PrintArrayList(List);
                break;
            }
        }
    }

    public static void DeleteStudentInfo(ArrayList<Student> List) {
        while (true) {
            System.out.println("请输入您要删除的学生的ID：");
            Scanner sc = new Scanner(System.in);
            String stuID = sc.next();
            boolean Flage = Constain(List, stuID);
            if (Flage) {
                int INDEX = GetIndex(List, stuID);
                List.remove(INDEX);
                System.out.println(stuID + "学生删除成功!");
                PrintArrayList(List);
                break;
            } else {
                System.out.println("当前ID不存在请重新输入！");
            }
        }
    }

    public static int GetIndex(ArrayList<Student> List, String ID) {
        for (int i = 0; i < List.size(); i++) {
            Student Stud = List.get(i);
            String listId = Stud.getId();
            if (listId.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public static void ChangeStudentInfo(ArrayList<Student> List) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要修改的学生信息的ID:");
        String ID = sc.next();
        boolean Flage = Constain(List, ID);
        if (Flage) {
            ChangeUserInfo(List, ID);
            return;
        }
        System.out.println("当前学生不存在请重新输入！");
    }

    public static void ChangeUserInfo(ArrayList<Student> List, String ID) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < List.size(); i++) {
            Student Stud = List.get(i);
            String listId = Stud.getId();
            if (listId.equals(ID)) {
                System.out.println("请输入学生ID：");
                String stuID = sc.next();
                System.out.println("请输入学生姓名：");
                String stuname = sc.next();
                System.out.println("请输入学生年龄：");
                int stuage = sc.nextInt();
                System.out.println("请输入学生地址：");
                String stuaddress = sc.next();
                Stud.setId(stuID);
                Stud.setName(stuname);
                Stud.setAge(stuage);
                Stud.setAddress(stuaddress);
            }
        }
        System.out.println("修改完毕！结果如下:");
        PrintArrayList(List);
    }

    public static void PrintArrayList(ArrayList<Student> List) {
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < List.size(); i++) {
            Student stu = List.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    public static boolean Constain(ArrayList<Student> List, String ID) {
        for (int i = 0; i < List.size(); i++) {
            Student Stud = List.get(i);
            String listId = Stud.getId();
            if (listId.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public static void FindeStudentInfo(ArrayList<Student> List) {
        if (List.size() == 0) {
            System.out.println("当前系统没有学生信息请去添加!");
            return;
        }
        PrintArrayList(List);
    }
}