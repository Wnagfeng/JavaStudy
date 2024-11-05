package org.example.controller;

import org.example.pojo.Student;
import org.example.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class studentController {
    @Autowired
    private studentService studentService;

    public void findAll() {
        List<Student> studentList = studentService.findAll();
        System.out.println("studentList = " + studentList);
    }
}
