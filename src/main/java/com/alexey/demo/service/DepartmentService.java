package com.alexey.demo.service;

import com.alexey.demo.entity.Department;
import com.alexey.demo.entity.Employee;

import java.util.List;
import java.util.Map;


public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getDepartments();

    Department findDepartment(Long id);

    List<Employee> findEmployees(Long id);

    Map<String, Double> showAverageSalary();

    void delete(Long id);
}
