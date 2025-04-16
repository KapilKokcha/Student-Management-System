package student.management.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;
import student.management.system.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(adminService.addStudent(dto));
    }

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO dto) {
        return ResponseEntity.ok(adminService.addCourse(dto));
    }

    @PutMapping("/assign")
    public ResponseEntity<Void> assignCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        adminService.assignCourseToStudent(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<StudentDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(adminService.getStudentsByName(name));
    }

    @GetMapping("/students/by-course")
    public ResponseEntity<List<StudentDTO>> getStudentsByCourse(@RequestParam Long courseId) {
        return ResponseEntity.ok(adminService.getStudentsByCourse(courseId));
    }

}
