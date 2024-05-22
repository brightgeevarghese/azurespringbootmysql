package miu.edu.cse.employeedemo.service;

import miu.edu.cse.employeedemo.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeDto>  createEmployee(EmployeeDto employeeDto);
    Optional<List<EmployeeDto>> getAllEmployees();
}
