package com.iss.SoapStudent;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private double fee;
	public Student() {}

    public Student(int id, String name,double fee) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    
}
