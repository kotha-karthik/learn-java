package com.iss.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeInfov2> employeelist;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String deptName) {
        this.name = deptName;
    }

    public List<EmployeeInfov2> getEmployeelist() {
        return employeelist;
    }
    public void setEmployeelist(List<EmployeeInfov2> employeelist) {
        this.employeelist = employeelist;
    }
}
