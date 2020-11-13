package com.alexey.demo.service;

import com.alexey.demo.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    Employee saveOrUpdate(Employee employee);

    void deleteEmployee(Long id);

    Employee findEmployee(Long id);

    List<Employee> getAllEmployeesWithDateBirthBetween(LocalDate startDate, LocalDate endDate);
}
