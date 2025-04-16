package student.management.system.mapper;

import org.springframework.stereotype.Component;
import student.management.system.dto.AddressDTO;
import student.management.system.dto.CourseDTO;
import student.management.system.dto.StudentDTO;
import student.management.system.entity.Address;
import student.management.system.entity.AddressType;
import student.management.system.entity.Course;
import student.management.system.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {
    public StudentDTO toDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .dateOfBirth(student.getDateOfBirth())
                .gender(student.getGender())
                .studentCode(student.getStudentCode())
                .addresses(toAddressDTOs(student.getAddresses()))
                .courses(student.getCourses().stream()
                        .map(Course::getCourseName)
                        .collect(Collectors.toSet()))
                .build();
    }

    public Student toEntity(StudentDTO dto) {
        Student student = Student.builder()
                .name(dto.getName())
                .dateOfBirth(dto.getDateOfBirth())
                .gender(dto.getGender())
                .studentCode(dto.getStudentCode())
                .build();

        List<Address> addressList = toAddressEntities(dto.getAddresses());
        addressList.forEach(a -> a.setStudent(student));
        student.setAddresses(addressList);

        return student;
    }

    public AddressDTO toAddressDTO(Address address) {
        return AddressDTO.builder()
                .type(address.getType().toString())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipcode())
                .build();
    }

    public List<AddressDTO> toAddressDTOs(List<Address> addresses) {
        return addresses.stream().map(this::toAddressDTO).collect(Collectors.toList());
    }

    public Address toAddressEntity(AddressDTO dto) {
        return Address.builder()
                .type(AddressType.valueOf(dto.getType()))
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .zipcode(dto.getZipCode())
                .build();
    }

    public List<Address> toAddressEntities(List<AddressDTO> dtos) {
        return dtos.stream().map(this::toAddressEntity).collect(Collectors.toList());
    }

    public CourseDTO toDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .courseType(course.getCourseType())
                .duration(course.getDuration())
                .topics(course.getTopics())
                .build();
    }

    public Course toEntity(CourseDTO dto) {
        return Course.builder()
                .courseName(dto.getCourseName())
                .description(dto.getDescription())
                .courseType(dto.getCourseType())
                .duration(dto.getDuration())
                .topics(dto.getTopics())
                .build();
    }
}
