package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName students
 */
@TableName(value ="students")
@Data
public class Students implements Serializable {
    private Integer studentid;

    private String name;

    private Object gender;

    private Date birthdate;

    private String major;

    private static final long serialVersionUID = 1L;
}