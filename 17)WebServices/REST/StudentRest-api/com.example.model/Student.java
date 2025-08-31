package com.example.model;
public class Student 
{
	private int sid;
    private String sname;
    private double fee;
    public Student() {}

    public Student(int sid, String sname, double fee) {
        this.sid = sid;
        this.sname = sname;
        this.fee = fee;
    }

    public int getSid() { return sid; }
    public void setSid(int sid) { this.sid = sid; }

    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}
