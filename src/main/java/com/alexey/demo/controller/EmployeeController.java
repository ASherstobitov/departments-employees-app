package com.alexey.demo.controller;

import com.alexey.demo.entity.Employee;
import com.alexey.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable Long id) {
        long tempId = employeeService.getEmployee(id).getDepartment().getId();
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployeesByDepartment(tempId);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long id) {
        return employeeService.getAllEmployeesByDepartment(id);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }


}
