package com.alexey.demo.controller;

import com.alexey.demo.dto.DateSearchDto;
import com.alexey.demo.entity.Employee;
import com.alexey.demo.service.DepartmentService;
import com.alexey.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("/delete/{id}")
    public List<Employee> deleteEmployee(@PathVariable Long id) {
        long tempId = employeeService.findEmployee(id).getDepartment().getId();
        employeeService.deleteEmployee(id);
        return departmentService.findEmployees(tempId);
    }

    @PostMapping("/birthday-between")
    public List<Employee> findEmployeesByDateBirthBetween(@RequestBody DateSearchDto dateSearchDto) {
        return employeeService.getAllEmployeesWithDateBirthBetween(dateSearchDto.getStartDate(),
                dateSearchDto.getEndDate());
    }








}
