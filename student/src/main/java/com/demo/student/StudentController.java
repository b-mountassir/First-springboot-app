package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
