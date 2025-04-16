package student.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.management.system.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
