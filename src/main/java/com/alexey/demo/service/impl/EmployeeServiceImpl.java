package com.alexey.demo.service.impl;

import com.alexey.demo.entity.Department;
import com.alexey.demo.entity.Employee;
import com.alexey.demo.exception.ResourceNotFoundException;
import com.alexey.demo.repository.DepartmentRepository;
import com.alexey.demo.repository.EmployeeRepository;
import com.alexey.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee must be with id");
        }
        Department theDepart = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department don't find by id: "
                        + employee.getDepartment().getId()));

        Employee theEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee don't find by id: "
                        + employee.getId()));

        theEmployee.setFirstName(employee.getFirstName());
        theEmployee.setLastName(employee.getLastName());
        theEmployee.setSalary(employee.getSalary());
        theEmployee.setDepartment(theDepart);
        theEmployee.setBirthday(employee.getBirthday());
        return employeeRepository.save(theEmployee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Department theDepart = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department don't find by id: "
                        + employee.getDepartment().getId()));
        employee.setDepartment(theDepart);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Long id) {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .filter(em -> em.getDepartment().getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new ResourceNotFoundException("Employee don't find by id: " + id);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
