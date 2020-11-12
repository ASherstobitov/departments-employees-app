package com.alexey.demo.service.impl;

import com.alexey.demo.entity.Department;
import com.alexey.demo.entity.Employee;
import com.alexey.demo.repository.DepartmentRepository;
import com.alexey.demo.repository.EmployeeRepository;
import com.alexey.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

   private final DepartmentRepository departmentRepository;

   private final EmployeeRepository employeeRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartment(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public List<Employee> findEmployees(Long id) {
        return employeeRepository.findAllByDepartment_Id(id);
    }

    @Override
    public Map<String, Double> showAverageSalary() {
        Map<String, Double> departsWithAverageSal = new TreeMap<>();
        for (Department department : getDepartments()) {
            double salary = getAverageSalary(findEmployees(department.getId()));
            departsWithAverageSal.put(department.getDepartName(), salary);
        }
        return departsWithAverageSal;
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }


    public Double getAverageSalary(List<Employee> employees) {
        if (employees != null) {
            DoubleSummaryStatistics stats = employees.stream()
                    .mapToDouble((x) -> x.getSalary())
                    .summaryStatistics();
            return stats.getAverage();
        }
        throw
                new NullPointerException("We don't have any employee!");

    }



}
