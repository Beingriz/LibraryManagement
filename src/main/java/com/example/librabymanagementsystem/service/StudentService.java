package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Enum.Gender;
import com.example.librabymanagementsystem.Enum.Status;
import com.example.librabymanagementsystem.Model.LibraryCard;
import com.example.librabymanagementsystem.Model.Student;
import com.example.librabymanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setStatus(Status.ACTIVE);
        libraryCard.setStudent(student); // Sending Studnet Object to Library Card
        student.setLibraryCard(libraryCard); // Setting Library card of student

        Student savedStudnet = studentRepository.save(student);
        return "Student Saved Successfully.";
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

    public List<String> maleStudents(Gender gender) {
        List<String> males = new ArrayList<>();
        List<Student> students = studentRepository.findByGender(gender);
        for (Student s : students){
            males.add(s.getName());
        }
        return males;
    }
}
