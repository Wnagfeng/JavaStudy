package org.example.service;

import org.example.dao.StudentDao;
import org.example.pojo.Student;

import java.util.List;

//接口
public interface StudentService {

    /**
     * 查询全部学员业务
     * @return
     */
    List<Student> findAll();

}

