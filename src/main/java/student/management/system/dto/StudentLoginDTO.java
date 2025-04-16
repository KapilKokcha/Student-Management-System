package student.management.system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentLoginDTO {
    private String studentCode;
    private LocalDate dateOfBirth;
}
