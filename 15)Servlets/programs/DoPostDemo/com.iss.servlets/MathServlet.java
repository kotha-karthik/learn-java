package com.iss.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.iss.models.Product;

/**3.x 
 * Servlet implementation class MathServlet
 */
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Product> products=new ArrayList<Product>();
    /**
     * Default constructor. 
     */
    public MathServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter	writer=response.getWriter();
		writer.write("<html><head></head><body>");
		writer.write("<form action='/DoPostDemo/doSum' method='post'>");
		writer.write("<input type='text' name='t1' id='t1'>");
		writer.write("<input type='text' name='t2' id='t2'>");
		writer.write("<input type='text' name='t3' id='t3'>");
		writer.write("<input type='submit' name='action' value='submit'>");
		writer.write("<input type='submit' name='action' value='display'>");
		writer.write("</form>");
		writer.write("</body></html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter	writer=response.getWriter();
		
		
		//String submitButton = request.getParameter("submit");
		//String displayButton = request.getParameter("display");
		String action = request.getParameter("action");

		if("submit".equals(action))
		{
			int x=Integer.parseInt( request.getParameter("t1"));
			String y=request.getParameter("t2");
			double z=Double.parseDouble(request.getParameter("t3"));
			Product p=new Product();
			p.setId(x);
			p.setName(y);
			p.setPrice(z);
			products.add(p);
			writer.write("<h1>product details submited</h1>");
		}
		else if("display".equals(action))
		{
			writer.write("<table border='1' style='border-collapse:collapse'>");
			writer.write("<tr><th>ID</th><th>Name</th><th>price</th></tr>");
			for(Product pro:products)
			{
				writer.write("<tr border='0'><td>"+pro.getId()+"</td>");
				writer.write("<td>"+pro.getName()+"</td>");
				writer.write("<td>"+pro.getPrice()+"</td></tr>");
			}
			writer.write("</table>");
			
		}
		
	}

}
