package student.management.system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;
import student.management.system.entity.Course;
import student.management.system.entity.Student;
import student.management.system.exception.ResourceNotFoundException;
import student.management.system.mapper.EntityMapper;
import student.management.system.repository.CourseRepository;
import student.management.system.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EntityMapper mapper;

    @Override
    @Transactional
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = mapper.toEntity(studentDTO);
//        student.getAddresses().forEach(a -> a.setStudent(student));
        return mapper.toDTO(studentRepo.save(student));
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = mapper.toEntity(courseDTO);
        return mapper.toDTO(courseRepo.save(course));
    }

    @Override
    @Transactional
    public void assignCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        student.getCourses().add(course);
        studentRepo.save(student);
    }

    @Override
    public List<StudentDTO> getStudentsByName(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        return studentRepo.findByCourses_Id(courseId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}
