package com.iss.SoapStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao 
{	
	
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\sqlexpress;databaseName=postman;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

            System.out.println(" Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public boolean addStudent(Student student) {
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO student(sid,sname,fee) VALUES (?, ?, ?)");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDouble(3, student.getFee());
       
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("sid"),
                    rs.getString("sname"),
                    rs.getDouble("fee")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
