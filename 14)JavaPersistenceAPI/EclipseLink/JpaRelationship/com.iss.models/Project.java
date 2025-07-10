package com.iss.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<EmployeeInfov2> employees;

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<EmployeeInfov2> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeInfov2> employees) {
        this.employees = employees;
    }
}
