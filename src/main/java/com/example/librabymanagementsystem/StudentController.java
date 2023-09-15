package com.example.librabymanagementsystem;

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
    public ResponseEntity addStudent(@RequestBody Student student){
        Student savedstudent = studentService.addStudent(student);
        return new ResponseEntity(savedstudent, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int id){
        Student student =  studentService.getStudent(id);
        if(student!=null){
            return new ResponseEntity<>(student, HttpStatus.FOUND);
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
        Student student = studentService.udpateAge(id, age);
        if(student!=null){
            return new ResponseEntity(student, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Invalid Student Reg. No!", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("all")
    public List<Student> getallStudents(){
        return studentService.getallStudents();
    }
    @GetMapping("getbygender")
    public List<Student> maleStudents(@RequestParam("gender") Gender gender){
        return studentService.maleStudents(gender);
    }

}
