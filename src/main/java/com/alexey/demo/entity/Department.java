package com.alexey.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;


@Entity
@Table(name = "department")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "department_name")
    private String departName;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public Department(long id) {
        this.id = id;
    }


    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }


}





