package com.example.librabymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        Student savedStudnet = studentRepository.save(student);
        return savedStudnet;
    }

    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) return student.get();
    return null;
    }

    public boolean deleteStudent(int id) {
        if(this.getStudent(id)!=null) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Student udpateAge(int id, int age) {
        if(this.getStudent(id)!=null){
            Student student = this.getStudent(id);
            student.setAge(age);
            return student;
        }
        return null;
    }

    public List<Student> getallStudents() {
        return studentRepository.findAll();
    }

    public List<Student> maleStudents(Gender gender) {
        return studentRepository.findByGender(gender);
    }
}
