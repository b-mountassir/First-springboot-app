package com.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("{id}")
    public Student getOne(@PathVariable("id") Long id){
        return studentService.getOneStudent(id);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentRegistrationRequest student){
        studentService.registerStudent(student);
    }


}
