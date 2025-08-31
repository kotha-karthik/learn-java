package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection 
{
	private static final String URL =
	        "jdbc:sqlserver://localhost\\sqlexpress;" +
	        "databaseName=postman;" +
	        "integratedSecurity=true;" +
	        "encrypt=true;" +
	        "trustServerCertificate=true";

	    static {
	        try {
	            // Load the Microsoft SQL Server JDBC Driver
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to load SQL Server JDBC Driver", e);
	        }
	    }

	    public static Connection getConnection() throws Exception {
	        return DriverManager.getConnection(URL);
	    }

}
