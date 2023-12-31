package com.example.librabymanagementsystem.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    String name;
    String email;
    String cardIssueNo;
    int age;
    String message;
    CardResponseDTO cardResponseDTO;
}
