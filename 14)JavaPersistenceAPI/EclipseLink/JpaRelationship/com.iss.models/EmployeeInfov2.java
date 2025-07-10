package com.iss.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EmployeeInfov2 {

    @Id
    private int empid;

    private String empname;
    private double salary;
    private String empdep;

    // One-to-One with Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // Many-to-One with Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Many-to-Many with Projects
    @ManyToMany
    @JoinTable(
        name = "employee_project",
        joinColumns = @JoinColumn(name = "empid"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    // Getters and Setters
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmpdep() {
        return empdep;
    }
    public void setEmpdep(String empdep) {
        this.empdep = empdep;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
