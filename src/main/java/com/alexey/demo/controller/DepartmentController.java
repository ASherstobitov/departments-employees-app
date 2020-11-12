package com.alexey.demo.controller;

import com.alexey.demo.entity.Department;
import com.alexey.demo.entity.Employee;
import com.alexey.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department) {

        Department tehDepart = new Department(department.getDepartName());

        return departmentService.createDepartment(tehDepart);
    }

    @GetMapping("/show-employees/{id}")
    public List<Employee> showEmployees(@PathVariable Long id) {
      return departmentService.findEmployees(id);
    }


    @GetMapping("/get-departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/find-department/{id}")
    public Department findDepartment(@PathVariable Long id) {
        return departmentService.findDepartment(id);
    }

    @GetMapping("/average-salary")
    public Map<String, Double> showAverageSalary() {
       return departmentService.showAverageSalary();
    }

    @DeleteMapping("/delete/{id}")
    public List<Department> deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return departmentService.getDepartments();
    }



}
