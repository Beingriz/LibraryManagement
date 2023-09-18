package com.example.librabymanagementsystem.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IssueBookResponse {
    String StudentName;

}
