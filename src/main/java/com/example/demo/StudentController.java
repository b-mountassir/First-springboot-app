package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @GetMapping("{id}")
    public Student getOne(@PathVariable("id") Long id){
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Student> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        repository.save(student);
        return student;
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> patchOne(@PathVariable("id") Long id, @RequestBody Student std){
        Student student = repository.findById(id).orElse(null);
        student.setFirstName(std.getFirstName());
        student.setLastName(std.getLastName());
        student.setEmail(std.getEmail());
        student.setAge(std.getAge());

        repository.save(student);
        return ResponseEntity.ok(student);

    }

    @DeleteMapping("{id}")
    public void deleteOne(@PathVariable("id") Long id){
        Student student = repository.findById(id).orElse(null);
        repository.delete(student);
    }

}
