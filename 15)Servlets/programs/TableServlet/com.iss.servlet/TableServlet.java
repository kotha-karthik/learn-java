package com.iss.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class TableServlet
 */
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int row=Integer.parseInt(request.getParameter("row"));
		int col=Integer.parseInt(request.getParameter("column"));
		out.println("<html> <head> <h1> Table </h1> </head>");
		out.println("<body > <table border='1'>");
		int c=1;
    	for (int i = 0; i < row; i++) 
		{
        	out.println("<tr border='0' >");

        	for (int j = 0; j < col; j++) 
			{
        		out.println("<td >" + (c)+"</td>");
				c++;
        	}
        	out.println("</tr><br>");
    	}

    		out.println("</table> </body> </html>");
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
