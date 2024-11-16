package org.example.pojo;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer classId;      // 外键，指向班级ID
}
