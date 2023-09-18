package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Enum.Gender;
import com.example.librabymanagementsystem.Enum.Status;
import com.example.librabymanagementsystem.Model.LibraryCard;
import com.example.librabymanagementsystem.Model.Student;
import com.example.librabymanagementsystem.dto.requestDTO.StudentRequest;
import com.example.librabymanagementsystem.dto.responseDTO.CardResponseDTO;
import com.example.librabymanagementsystem.dto.responseDTO.StudentResponse;
import com.example.librabymanagementsystem.repository.StudentRepository;
import com.example.librabymanagementsystem.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentResponse addStudent(StudentRequest studentRequest) {

        // converting Request DTO to Model
           Student student = Student.builder()
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .name(studentRequest.getName())
                .gender(studentRequest.getGender())
                .build();

        // Setting Librarby Card to Student.
        LibraryCard libraryCard = LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .status(Status.ACTIVE)
                .student(student)
                .build();

        student.setLibraryCard(libraryCard); // Setting Library card of student */

        Student savedStudnet = studentRepository.save(student);
//        Converting model to Response DTO

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(savedStudnet.getName());
        studentResponse.setEmail(savedStudnet.getEmail());
        studentResponse.setAge(savedStudnet.getAge());


        CardResponseDTO cardResponseDTO =  new CardResponseDTO();
        cardResponseDTO.setCardNo(savedStudnet.getLibraryCard().getCardNo());
        cardResponseDTO.setStatus(savedStudnet.getLibraryCard().getStatus());
        cardResponseDTO.setIssueDate(savedStudnet.getLibraryCard().getIssueDate());

        studentResponse.setCardResponseDTO(cardResponseDTO);
        studentResponse.setMessage("You have been Saved!!");


        return studentResponse;
    }

    public StudentResponse getStudent(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setName(student.getName());
            studentResponse.setEmail(student.getEmail());
            studentResponse.setAge(student.getAge());
            return studentResponse;
        }
    return null;
    }

    public boolean deleteStudent(int id) {
        if(this.getStudent(id)!=null) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public StudentResponse udpateAge(int id, int age) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setAge(age);
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setName(student.getName());
            studentResponse.setAge(student.getAge());
            studentResponse.setEmail(student.getEmail());
            studentResponse.setMessage("Found Student!");
            return studentResponse;
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
