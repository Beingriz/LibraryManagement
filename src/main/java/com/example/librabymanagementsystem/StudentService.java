package com.example.librabymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        Student savedStudnet = studentRepository.save(student);
        return savedStudnet;
    }
}
