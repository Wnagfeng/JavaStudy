package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("users")
// TableName注解用于指定数据库表名 默认是你实体类名的小写形式
@Data
public class Users {
    private int id;      // 小写开头
    private String name; // 小写开头
    private String email; // 小写开头
}
