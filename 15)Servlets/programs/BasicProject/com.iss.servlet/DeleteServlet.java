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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		PrintWriter out=response.getWriter();
		out.write("<!DOCTYPE html>");
	    out.write("<html lang='en'><head>");
	    out.write("<meta charset='UTF-8'>");
	    out.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	    out.write("<title>Delete Product</title>");
	    out.write("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
	    out.write("</head><body>");
	    out.write("<div class='container py-5'>");
		String action = request.getParameter("action");
		
        response.setContentType("text/html");
        
        int id=Integer.parseInt(request.getParameter("id"));
        try (Connection con = getConnection()) {
        	PreparedStatement pstmt = con.prepareStatement("Delete From product WHERE pid = ?");
        	pstmt.setInt(1, id);  
        	int rs = pstmt.executeUpdate();
        	
        	if (rs > 0) {
                out.write("<div class='alert alert-success mt-3'>Product deleted successfully!</div>");
        		//response.sendRedirect("ProductServlet");
            } else {
                out.write("<div class='alert alert-warning mt-3'>No product found with ID: " + id + "</div>");
            }
        	
        }catch(SQLException e) {
            out.write("<div class='alert alert-danger mt-3'>Error: " + e.getMessage() + "</div>");
        }
        
       
        out.write("<form action='ProductServlet' method='post'>");
        out.write("<button type='submit' name='action' value='display' class='btn btn-primary mt-3'>Back to Product List</button>");
        out.write("</form>");
        out.write("</div></body></html>");
    
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
