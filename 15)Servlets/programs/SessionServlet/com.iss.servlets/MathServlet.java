package com.iss.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import com.iss.models.Product;

/**3.x 
 * Servlet implementation class MathServlet
 */
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	
	
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
		
		HttpSession session=request.getSession();
		products=(List<Product>)session.getAttribute("products");
		String deleteIdStr = request.getParameter("deleteId");
	    if (deleteIdStr != null)
	    {
	    	int delete=Integer.parseInt(deleteIdStr);
	    	for(int i=0;i<products.size();i++)
	    	{
	    		if(products.get(i).getId()==delete)
	    		{
	    			products.remove(i);
	    			break;
	    		}
	    	}
	    }
	    
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
		
		//Cookie cookie=new Cookie("username","karthik");
		//response.addCookie(cookie);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter	writer=response.getWriter();
		
		HttpSession session=request.getSession(true);
		products=(List<Product>) session.getAttribute("products");
    	if(products==null)
		{
			products=new ArrayList<Product>();
			session.setAttribute("products",products);
		}
		
		
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
				writer.write("<td>"+pro.getPrice()+"</td>");
				writer.write("<td><a href='doSum?deleteId=" + pro.getId() + "'>Delete</a></td></tr>");
			}
			writer.write("</table>");
			
		}
		
	}

}
