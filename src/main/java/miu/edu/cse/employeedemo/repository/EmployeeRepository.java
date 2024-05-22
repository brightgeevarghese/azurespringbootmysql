package miu.edu.cse.employeedemo.repository;

import miu.edu.cse.employeedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
