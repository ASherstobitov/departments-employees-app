package com.alexey.demo.service.impl;

import com.alexey.demo.entity.Department;
import com.alexey.demo.entity.Employee;
import com.alexey.demo.repository.DepartmentRepository;
import com.alexey.demo.repository.EmployeeRepository;
import com.alexey.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveOrUpdate(Employee employee) {

        Department theDepart = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);

        if (theDepart == null) {
            theDepart = new Department();
            theDepart.setDepartName(employee.getDepartment().getDepartName());
        }

        Employee theEmployee = findEmployee(employee.getId());

        if (theEmployee == null) {
            theEmployee = new Employee(employee.getFirstName(), employee.getLastName(),
                    employee.getBirthday(), employee.getSalary(), theDepart);
            employee.setDepartment(theDepart);
        } else
        theEmployee.setFirstName(employee.getFirstName());
        theEmployee.setLastName(employee.getLastName());
        theEmployee.setDepartment(theDepart);
        theEmployee.setBirthday(employee.getBirthday());

//        theDepart.addEmployee(employee);
      return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}
