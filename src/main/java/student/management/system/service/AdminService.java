package student.management.system.service;

import org.springframework.stereotype.Service;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;

import java.util.List;


public interface AdminService {
    StudentDTO addStudent(StudentDTO studentDTO);
    CourseDTO addCourse(CourseDTO courseDTO);
    void assignCourseToStudent(Long studentId, Long courseId);
    List<StudentDTO> getStudentsByName(String name);
    List<StudentDTO> getStudentsByCourse(Long courseId);
}
