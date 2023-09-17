package com.example.librabymanagementsystem.Model;

import com.example.librabymanagementsystem.Enum.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // It will Automatically Generate the PK Value, by Incrementing by 1
    int id;
    String cardNo; // AutoGeneration using UUID.randon() method

    @Enumerated(EnumType.STRING)
    Status status;
    // SQL Date will have only Date, UTIL Date has date and Time Stamp Both.
    @CreationTimestamp
    Date issueDate;

    @OneToOne
    @JoinColumn // Used to introduce foreign key in child class.
    Student student;
}
