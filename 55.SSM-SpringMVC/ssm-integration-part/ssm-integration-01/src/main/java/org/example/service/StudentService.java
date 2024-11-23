package org.example.service;

import org.example.pojo.Student;

import java.util.List;

public interface StudentService {


    List<Student> getStudents();

    void insertStudent(Student student);

    void deleteStudent(int id);

    void updateStudent(int id, Student student);

    Student getStudentById(int id);
}
