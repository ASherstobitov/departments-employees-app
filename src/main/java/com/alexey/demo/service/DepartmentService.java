package com.alexey.demo.service;

import com.alexey.demo.entity.Department;
import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);

    Department saveDepartment(Department department);

    Department updateDepartment(Department department);
}
