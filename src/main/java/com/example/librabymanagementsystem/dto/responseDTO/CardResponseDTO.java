package com.example.librabymanagementsystem.dto.responseDTO;

import com.example.librabymanagementsystem.Enum.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponseDTO {
    String cardNo; // AutoGeneration using UUID.randon() method
    Status status;
    Date issueDate;

}
