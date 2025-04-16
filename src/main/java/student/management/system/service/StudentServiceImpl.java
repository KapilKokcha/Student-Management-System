package student.management.system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.management.system.dto.AddressDTO;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;
import student.management.system.entity.Address;
import student.management.system.entity.Course;
import student.management.system.entity.Student;
import student.management.system.exception.ResourceNotFoundException;
import student.management.system.mapper.EntityMapper;
import student.management.system.repository.CourseRepository;
import student.management.system.repository.StudentRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EntityMapper mapper;

    @Override
    @Transactional
    public StudentDTO updateProfile(Long studentId, StudentDTO dto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));


        if (dto.getAddresses() != null && !dto.getAddresses().isEmpty()) {
            for (AddressDTO addressDTO : dto.getAddresses()) {
                Address address = mapper.toAddressEntity(addressDTO);
                address.setStudent(student);
                student.getAddresses().add(address);
            }
        }

        Student updated = studentRepository.save(student);
        return mapper.toDTO(updated);
    }

    @Override
    public Set<CourseDTO> getAssignedCourses(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return student.getCourses().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public void leaveCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        student.getCourses().remove(course);
        studentRepository.save(student);
    }

}
