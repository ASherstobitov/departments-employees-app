package com.alexey.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
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
    private Long id;

    @NonNull
    @Column(name = "department_name")
    private String departName;

    @Column(name = "average_salary")
    private String averageSalary;

    @Column(name = "amount_employees")
    private int amountEmployees;;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;


}





