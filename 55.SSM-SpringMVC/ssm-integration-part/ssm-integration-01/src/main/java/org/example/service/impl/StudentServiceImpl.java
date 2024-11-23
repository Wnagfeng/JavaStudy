package org.example.service.impl;

import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //注入StudentMapper
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentMapper.updateStudent(id, student);
    }


    @Override
    public Student getStudentById(int id) {
        return studentMapper.selectById(id);
    }
}
