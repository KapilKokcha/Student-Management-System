package student.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import student.management.system.entity.Student;

@SpringBootApplication
@EnableJpaRepositories
public class StudentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
        Student student=new Student();
        student.setName("hehe");
        System.out.println(student.getName());
    }

}
