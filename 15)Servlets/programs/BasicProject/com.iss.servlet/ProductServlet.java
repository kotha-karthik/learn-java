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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
      
    
    public ProductServlet() {
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.write("<html><head></head><body>");
		out.write("<h2>Hello</h2></body></html>");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		System.out.println(id);
		System.out.println(name);
		System.out.println(price);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
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

        out.write("<div class='row mb-3'>");
        out.write("<div class='col-md-4'><label class='form-label'>Product ID</label><input type='text' class='form-control' name='id'></div>");
        out.write("<div class='col-md-4'><label class='form-label'>Product Name</label><input type='text' class='form-control' name='name'></div>");
        out.write("<div class='col-md-4'><label class='form-label'>Price</label><input type='number' step='0.01' class='form-control' name='price'></div>");
        out.write("</div>");

        out.write("<div class='d-flex justify-content-between'>");
        out.write("<button type='submit' name='action' value='save' class='btn btn-success'>Save</button>");
        out.write("<button type='submit' name='action' value='update' class='btn btn-warning'>Update</button>");
        out.write("<button type='submit' name='action' value='display' class='btn btn-info'>Display</button>");
        out.write("</div>");

        out.write("</form>");
        out.write("</div>"); 

        
        if ("display".equals(action)) {
            try (Connection conn = getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM product");
                
                out.write("<div class='card p-3'>");
                out.write("<h4 class='mb-3'>Product List</h4>");
                out.write("<table class='table table-bordered table-striped text-center'>");
                out.write("<thead class='table-dark'><tr><th>ID</th><th>Name</th><th>Price</th><th>Edit</th><th>Delete</th></tr></thead><tbody>");

                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    out.write("<tr>");
                    out.write("<td>" + rs.getString("pid") + "</td>");
                    out.write("<td>" + rs.getString("pname") + "</td>");
                    out.write("<td>$" + String.format("%.2f", rs.getDouble("price")) + "</td>");
                    
                    
                    out.write("<td><a href='Edit?id=" + rs.getString("pid") + "' class='btn btn-warning btn-sm'>Edit</a></td>");

                    
                    out.write("<td><a href='Delete?id=" + rs.getString("pid") + "' class='btn btn-danger btn-sm'>Delete</a></td>");

                    
                    out.write("</tr>");
                }

                if (!hasData) {
                    out.write("<tr><td colspan='3' class='text-danger'>No products found</td></tr>");
                }

                out.write("</tbody></table>");
                out.write("</div>");

            } catch (SQLException e) {
                out.write("<div class='alert alert-danger mt-3'>Error: " + e.getMessage() + "</div>");
            }
        }
        PreparedStatement ps;
        if ("save".equals(action)) {
            try {
            	Connection con = getConnection();
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                ps = con.prepareStatement("Insert into product values(?,?,?)");

                ps.setInt(1, id); 
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.executeUpdate();
                

                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format: " + e.getMessage());
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
        
        if ("update".equals(action)) {
            try {
            	Connection con = getConnection();
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                ps = con.prepareStatement("update product set pname=?,price=? where pid=?");

                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setInt(3, id); 
                ps.executeQuery();
                

                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format: " + e.getMessage());
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        
        out.write("</div></body></html>");
	
	}

}
