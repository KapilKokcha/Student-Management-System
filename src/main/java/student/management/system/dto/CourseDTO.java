package student.management.system.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    private Long id;
    private String courseName;
    private String description;
    private String courseType;
    private String duration;
    private List<String> topics;
}
