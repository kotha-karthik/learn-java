package com.iss.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/Edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con; 
    private ResultSet rs;
    
    public EditServlet() {
        super();
        
    }
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=servlet;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        
        
        // rendering Same pages here!!!
        out.write("<!DOCTYPE html>");
        out.write("<html lang='en'><head>");
        out.write("<meta charset='UTF-8'>");
        out.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.write("<title>Product Page</title>");
        out.write("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.write("</head><body>");
        out.write("<div class='container py-5'>");
        out.write("<div class='card p-4 mb-4'>");
        out.write("<h3 class='text-center mb-4'>Product Entry</h3>");
        out.write("<form action='/BasicProject/ProductServlet' method='post'>");
        
        
        try (Connection con = getConnection()) {
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product WHERE pid = ?");
        	pstmt.setInt(1, id);  
        	rs = pstmt.executeQuery();
        	if(rs.next())
        	{
		        out.write("<div class='row mb-3'>");
		        out.write("<div class='col-md-4'><label class='form-label'>Product ID</label><input type='text' class='form-control' name='id' value='"+rs.getString("pid")+"'></div>");
		        out.write("<div class='col-md-4'><label class='form-label'>Product Name</label><input type='text' class='form-control' name='name' value='"+rs.getString("pname")+"'></div>");
		        out.write("<div class='col-md-4'><label class='form-label'>Price</label><input type='number' step='0.01' class='form-control' name='price' value='"+rs.getString("price")+"'></div>");
		        out.write("</div>");
		        out.write("<div class='d-flex justify-content-between'>");
		        out.write("<button type='submit' name='action' value='save' class='btn btn-success'>Save</button>");
		        out.write("<button type='submit' name='action' value='update' class='btn btn-warning'>Update</button>");
		        out.write("<button type='submit' name='action' value='display' class='btn btn-info'>Display</button>");
		        out.write("</div>");

		        out.write("</form>");
		        out.write("</div>"); 
		        out.write("</div></body></html>");
        	}else {
        	    out.write("<p>No product found with the given ID.</p>");
        	}
        }
        catch(SQLException e) {
            out.write("<div class='alert alert-danger mt-3'>Error: " + e.getMessage() + "</div>");
        }
        

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
