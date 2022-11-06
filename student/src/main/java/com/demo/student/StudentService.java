package com.demo.student;

import org.springframework.stereotype.Service;

@Service
public record StudentService(StudentRepository studentRepository) {
    public void registerStudent(StudentRegistrationRequest request){
        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .age(request.age())
                .build();
        studentRepository.save(student);
    }

    public Student getOneStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }
}
