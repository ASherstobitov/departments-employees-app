package com.alexey.demo.service;

import com.alexey.demo.entity.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployeesByDepartment(Long id);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

}
