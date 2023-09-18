package com.example.librabymanagementsystem.service.impl;

import com.example.librabymanagementsystem.Enum.Gender;
import com.example.librabymanagementsystem.Model.Student;
import com.example.librabymanagementsystem.dto.requestDTO.StudentRequest;
import com.example.librabymanagementsystem.dto.responseDTO.StudentResponse;

import java.util.List;

public interface StudentService {
    public List<String> maleStudents(Gender gender);
    public List<Student> getallStudents();
    public StudentResponse udpateAge(int id, int age);
    public boolean deleteStudent(int id);
    public StudentResponse getStudent(int id);
    public StudentResponse addStudent(StudentRequest studentRequest);
}
