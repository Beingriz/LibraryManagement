package com.example.librabymanagementsystem.repository;

import com.example.librabymanagementsystem.Enum.Gender;
import com.example.librabymanagementsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    List<Student> findByGender(Gender gender);

}

