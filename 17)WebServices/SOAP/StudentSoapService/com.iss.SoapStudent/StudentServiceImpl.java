package com.iss.SoapStudent;

import java.util.List;

import jakarta.jws.WebService;

@WebService(endpointInterface="com.iss.SoapStudent.StudentService")

public class StudentServiceImpl implements StudentService 
{
	private StudentDao dao=new StudentDao();
	
	public String addStudent(int id,String name,double fee)
	{
		Student s=new Student(id,name,fee);
		boolean result=dao.addStudent(s);
		return result ? "Student added successfully!" : "Failed to add student!";
	}
	public List<Student> getAllStudents()
	{
			return dao.getStudents();
	}

}
