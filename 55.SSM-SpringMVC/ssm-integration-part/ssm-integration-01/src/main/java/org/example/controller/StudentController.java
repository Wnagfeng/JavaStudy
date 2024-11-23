package org.example.controller;

import org.example.pojo.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    //    注入Service层
    @Autowired
    private StudentService studentService;

    //    学生信息查询
    @GetMapping("/getStudent")
    public List<Student> getStudent() {
        List<Student> students = studentService.getStudents();
        return students;
    }

    //    学生信息添加
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        System.out.println("Received student: " + student);
        studentService.insertStudent(student);
        return "success";
    }

    //    学生信息删除
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "success";
    }

    //    学生信息修改
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestParam int id, @RequestBody Student student) {

        studentService.updateStudent(id, student);
        return "success";
    }

    //   根据id查询学生信息
    @GetMapping("/getStudentById")
    public Student getStudentById(@RequestParam int id) {
        Student student = studentService.getStudentById(id);
        return student;
    }
}
