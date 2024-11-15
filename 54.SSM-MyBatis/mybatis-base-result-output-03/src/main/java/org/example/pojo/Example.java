package org.example.pojo;

public class Example {
    private String id;  // 改为 String 类型// 确保类型与数据库表中的字段类型一致
    private String name;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
