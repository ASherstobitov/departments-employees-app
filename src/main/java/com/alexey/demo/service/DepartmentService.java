package com.alexey.demo.service;

import com.alexey.demo.entity.Department;
import java.util.List;

public interface DepartmentService {


    List<Department> getDepartments();


    Department getDepartment(Long id);

    void delete(Long id);

    Department saveOrUpdate(Department department);

}
