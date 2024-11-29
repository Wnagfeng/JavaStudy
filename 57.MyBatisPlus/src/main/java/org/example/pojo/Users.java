package org.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("users")
// TableName注解用于指定数据库表名 默认是你实体类名的小写形式
@Data
public class Users {
    /*
     * 默认是雪花算法生成id，也可以自己指定id 前提是你的数据库是long类型
     * AUTO 就是自增长策略 前提是你的数据库是支持自增长的
     * */
    @TableId(type = IdType.AUTO)// 主键自增策略
    private int id;      // 小写开头
    @TableField(value = "name", exist = true)// 如果你把exist设置为false，则不会映射到数据库字段 查询的时候也不会返回该字段
    private String name; // 小写开头
    private String email; // 小写开头
    //    逻辑删除
    @TableLogic// 这段就是逻辑删除 当你删除数据的时候 他会自动修改这里的数据 改为 0 未删除 1 已删除
    //当你查询的时候会默认查询 deleted=0 的数据
    private Integer deleted; // 小写开头

    //     乐观锁
    @Version// 这段就是乐观锁 当你更新数据的时候 他会自动加 1 到 version 字段
    private Integer version; // 小写开头
}
