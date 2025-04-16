package student.management.system.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String studentCode;
    private List<AddressDTO> addresses;
    private Set<String> courses;
}
