package org.example.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class StudentController {

    @Autowired
    //@Resource
    private StudentService studentService;
}
