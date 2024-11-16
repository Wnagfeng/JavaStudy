package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
    private Integer classId;
    private String className;
    private Integer schoolId;      // 外键，指向学校ID
    private List<Student> students; // 班级下的学生列表
}
