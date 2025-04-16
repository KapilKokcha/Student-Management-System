package student.management.system.service;

import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;

import java.util.List;
import java.util.Set;

public interface StudentService {
    StudentDTO updateProfile(Long studentId, StudentDTO updatedProfile);

    Set<CourseDTO> getAssignedCourses(Long studentId);

    void leaveCourse(Long studentId, Long courseId);

}
