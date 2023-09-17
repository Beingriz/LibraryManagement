package com.example.librabymanagementsystem.dto.requestDTO;

import com.example.librabymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    String name;
    int age;
    Gender gender;
    String email;

}
