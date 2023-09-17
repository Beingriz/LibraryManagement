package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.Enum.Gender;
import com.example.librabymanagementsystem.Model.Student;
import com.example.librabymanagementsystem.dto.requestDTO.StudentRequest;
import com.example.librabymanagementsystem.dto.responseDTO.StudentResponse;
import com.example.librabymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse savedstudent = studentService.addStudent(studentRequest);
        return new ResponseEntity<StudentResponse>(savedstudent, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int id){
        StudentResponse student =  studentService.getStudent(id);
        if(student!=null){
            return new ResponseEntity<StudentResponse>(student, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Invalid Reg. Id", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        if(studentService.deleteStudent(id)){
            return new ResponseEntity<>("Student Deleted Successfully!", HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Invalid Reg. Id", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity updateAge(@RequestParam("id") int id, @RequestParam("age") int age){
        StudentResponse student = studentService.udpateAge(id, age);
        if(student!=null){
            return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Invalid Student Reg. No!", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("all")
    public List<Student> getallStudents(){
        return studentService.getallStudents();
    }
    @GetMapping("geet-males")
    public List<String> maleStudents(@RequestParam("gender") Gender gender){
        return studentService.maleStudents(gender);
    }

}
