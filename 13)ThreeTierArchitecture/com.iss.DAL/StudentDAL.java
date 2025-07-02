package com.iss.DAL;

import com.iss.models.StudentInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAL {
	
	private PreparedStatement pstmt;
	private Connection con;
	
	public StudentDAL() throws Exception {
		
		try{
			 con=DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=studentdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
			
		}catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	public void save(StudentInfo studentinfo) throws Exception
	{
		try {
			pstmt=con.prepareStatement("insert into studentinfo values(?,?,?)");
			pstmt.setInt(1,studentinfo.getId());
			pstmt.setString(2, studentinfo.getName());
			pstmt.setDouble(3, studentinfo.getFee());
			pstmt.executeUpdate();
		}catch(Exception ex)
		{
			throw ex;
		}
	}
}
