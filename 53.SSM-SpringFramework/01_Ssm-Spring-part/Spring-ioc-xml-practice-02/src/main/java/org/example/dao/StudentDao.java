package org.example.dao;

import org.example.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//接口
public interface StudentDao {

    /**
     * 查询全部学生数据
     *
     * @return
     */
    List<Student> queryAll();
}

