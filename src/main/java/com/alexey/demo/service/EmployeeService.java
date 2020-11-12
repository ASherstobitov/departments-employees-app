package com.alexey.demo.service;

import com.alexey.demo.entity.Employee;

public interface EmployeeService {
    Employee saveOrUpdate(Employee employee);

    void deleteEmployee(Long id);

    Employee findEmployee(Long id);

}
