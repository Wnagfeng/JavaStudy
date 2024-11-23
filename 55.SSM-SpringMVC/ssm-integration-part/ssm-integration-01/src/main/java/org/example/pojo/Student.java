//package org.example.pojo;
//
//import lombok.Data;
//
//@Data
//public class Student {
//    private String Name;      // 姓名，确保属性名称符合 Java Bean 命名规范
//    private String Gender;    // 性别
//    private String BirthDate; // 如果需要，可以换成合适的类型
//    private String Major;     // 专业
//}

package org.example.pojo;

import lombok.Data;

@Data
public class Student {
    private String studentId; // 学生编号
    private String name;      // 姓名
    private String gender;    // 性别
    private String birthDate; // 出生日期
    private String major;     // 专业
}

//这里的实体类大小写都可以
// 这是前端传递的数据
/*
* {
    "name": "Tom",
    "gender": "男",
    "birthDate": "2000-01-01",
    "major": "计算机科学"
}
*
* */
//我用大大写实体类和小写实体类，然后json都是小写，都可以执行插入
//好像是因为我开启了大小写映射

//然后我刚刚又去看了插入的sql语句，发现是小写，我感觉这个ssm你需要指定一个规则
//比如你的实体类是小写，那么插入语句也要小写，要不然太乱了！
//     INSERT INTO Students (Name, Gender, BirthDate, Major)
//        VALUES (#{name}, #{gender}, #{birthDate}, #{major})


