package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private Integer id;
    private String name;
    private List<Classes> classes; // 学校下的班级列表
}
