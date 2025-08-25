package com.iss.SoapStudent;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService
public interface StudentService {
	
	@WebMethod
	public String addStudent(
			@WebParam(name = "id") int id,
	        @WebParam(name = "sname") String name,
	        @WebParam(name = "fee") double fee
			);
	@WebMethod
	public List<Student> getAllStudents();

}
