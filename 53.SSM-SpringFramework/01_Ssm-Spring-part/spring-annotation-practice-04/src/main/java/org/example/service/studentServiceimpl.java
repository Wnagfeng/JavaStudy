package org.example.service;

import org.example.dao.studentDao;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceimpl implements studentService {
    @Autowired
    private studentDao studentDao;


    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        return studentList;
    }
}
