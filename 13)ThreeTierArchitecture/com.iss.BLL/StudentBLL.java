package com.iss.BLL;

import com.iss.DAL.StudentDAL;
import com.iss.models.StudentInfo;

public class StudentBLL {
	
	private StudentDAL studentdal;
	
	public StudentBLL() throws Exception
	{
		try {
			studentdal=new StudentDAL();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void save(StudentInfo studentinfo) throws Exception
	{
	
		if(studentinfo.getFee() < 500)
		{
			throw new Exception("Fee can't be less than 500");
		}
		
		try {
			studentdal.save(studentinfo);
		}catch(Exception ex)
		{
			throw ex;
		}
	}
	
}
