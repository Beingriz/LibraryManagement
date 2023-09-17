package com.example.librabymanagementsystem.Model;

import com.example.librabymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    int age;

    @Column(unique = true, nullable = false) // Sets the Column unique.
    String email;

    @OneToOne (mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard libraryCard;


}
