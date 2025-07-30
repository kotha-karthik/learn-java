package com.iss.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
        String password = request.getParameter("password");
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=servlet;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
            
            PreparedStatement ps = con.prepareStatement("select * from auth where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cookie authCookie = new Cookie("auth", "valid");
                authCookie.setMaxAge(3600);
                response.addCookie(authCookie);

                
                if ("admin".equalsIgnoreCase(username)) {
                	 request.getRequestDispatcher("ProductServlet").forward(request, response);
                } else {
                   
                    request.getRequestDispatcher("UserProductServlet").forward(request, response);
                }
            } else {
                
                request.setAttribute("errorMessage", "Invalid username or password.");
                request.getRequestDispatcher("/login.html").forward(request, response);
            }

        } catch (Exception ex) {
            throw new ServletException("Database authentication failed", ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	

}
