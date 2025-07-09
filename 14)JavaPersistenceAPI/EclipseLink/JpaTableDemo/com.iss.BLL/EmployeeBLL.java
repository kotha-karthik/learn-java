package com.iss.BLL;

import java.util.List;

import com.iss.DAL.EmployeeDAL;
import com.iss.models.EmployeeInfo;


public class EmployeeBLL 
{
	private EmployeeDAL empdal;
	public EmployeeBLL()
	{
		empdal=new EmployeeDAL();
	}
	public boolean addEmployee(EmployeeInfo emp) {
		try 
		{
			return empdal.add(emp);
		}catch(Exception ex)
		{
			throw ex;
		}
    }

   
    public boolean updateEmployee(EmployeeInfo emp) {
    	try {
        return empdal.update(emp);
    	}catch(Exception ex)
		{
			throw ex;
		}
    }

   
    public boolean deleteEmployee(int empid) {
    	try {
        return empdal.delete(empid);
    	}catch(Exception ex)
		{
			throw ex;
		}
    }

   
    public List<EmployeeInfo> getAllEmployee() {
    	try {
        return empdal.getAll();
    	}catch(Exception ex)
		{
			throw ex;
		}
    }

}
