package com.demo.student;

public record StudentRegistrationRequest(String firstName,
                                         String lastName,
                                         String email,
                                         Integer age) {
}
