package org.example.service;

import org.example.dao.StudentDao;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> GetAllList() {
        return studentDao.GetAllStudents();
    }
}
