package student.management.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;
    private String courseType;
    private String duration;

    @ElementCollection
    private List<String> topics;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
