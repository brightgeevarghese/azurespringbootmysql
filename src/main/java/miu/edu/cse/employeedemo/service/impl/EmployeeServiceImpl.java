package miu.edu.cse.employeedemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.employeedemo.dto.EmployeeDto;
import miu.edu.cse.employeedemo.model.Employee;
import miu.edu.cse.employeedemo.repository.EmployeeRepository;
import miu.edu.cse.employeedemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeDto> createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto dto = new EmployeeDto(
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
        return Optional.of(dto);
    }

    @Override
    public Optional<List<EmployeeDto>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        for (Employee employee : employees) {
            dtos.add(new EmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getEmail()));
        }
        return Optional.of(dtos);
    }
}
