package student.management.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;
import student.management.system.dto.StudentLoginDTO;
import student.management.system.entity.Student;
import student.management.system.mapper.EntityMapper;
import student.management.system.repository.StudentRepository;
import student.management.system.service.StudentService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final EntityMapper mapper;
    private final StudentRepository studentRepository;

    @PutMapping("/{studentId}/update-profile")
    public ResponseEntity<StudentDTO> updateStudentProfile(@PathVariable Long studentId, @RequestBody StudentDTO updatedProfile) {
        StudentDTO updatedStudent = studentService.updateProfile(studentId, updatedProfile);
        return ResponseEntity.ok(updatedStudent);
    }


    @GetMapping("/{studentId}/courses")
    public ResponseEntity<Set<CourseDTO>> getAssignedCourses(@PathVariable Long studentId) {
        Set<CourseDTO> courses = studentService.getAssignedCourses(studentId);
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> leaveCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.leaveCourse(studentId, courseId);
        return ResponseEntity.ok("Course left successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> studentLogin(@RequestBody StudentLoginDTO dto) {
        Optional<Student> studentOpt = studentRepository
                .findByStudentCodeAndDateOfBirth(dto.getStudentCode(), dto.getDateOfBirth());

        if (studentOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // We can send a student token here
        return ResponseEntity.ok("Valid");
    }

}
