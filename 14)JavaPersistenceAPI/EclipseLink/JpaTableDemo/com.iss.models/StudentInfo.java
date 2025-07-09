package com.iss.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeInfo {
	private int empid;
	private String empname;
	private double empsal;
	private String dep;
	@Id
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
	public double getEmpsal() {
		return empsal;
	}
	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	

}
