package com.iss.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentInfo {
	
	@Id
	private int id;
	private String name;
	private double fee;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
}
