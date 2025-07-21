package com.iss.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalculateServlet
 */
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalculateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        
		PrintWriter out = response.getWriter();
	        
		int t1=Integer.parseInt(request.getParameter("t1"));
		int t2=Integer.parseInt(request.getParameter("t2"));
		
		int total=t1+t2;
		/*response.sendRedirect("math.html?t1=" + t1 + "&t2=" + t2 + "&t3=" + total);*/
		
		/*out.println("<html><body><h1>");
		out.println(total);
		out.println("</h1></body></html>");*/


		out.println("<html><body><h1>");
		out.println("<form action='/ServletsDemo/CalculateServlet'>");
		out.println("<input type='text' name='t1' value= '" +t1+ " ' id='t1'><br>");
		out.println("<input type='text' name='t2' value= '" +t2+ " ' id='t2'><br>");
		out.println("<input type='text' name='t3' value= '" +total+ " ' id='t3'><br>");
		out.println("<input type='submit' value='Sum'>");
		out.println("</form>");

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
