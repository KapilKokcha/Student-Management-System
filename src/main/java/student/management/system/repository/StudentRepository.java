package student.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.management.system.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCase(String name);
    Optional<Student> findByStudentCode(String studentCode);
    List<Student> findByCourses_Id(Long courseId);
    List<Student> findByCourses_CourseNameIgnoreCase(String courseName);
    Optional<Student> findByStudentCodeAndDateOfBirth(String studentCode, LocalDate dateOfBirth);

}
