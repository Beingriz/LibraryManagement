package com.example.librabymanagementsystem.dto.responseDTO;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Author;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {
    String title;

    int noOfPages;

    Genre genre;
    double cost;
    String author;
}
