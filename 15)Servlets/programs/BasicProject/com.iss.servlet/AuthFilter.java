package com.iss.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebFilter("/ProductServlet")
public class AuthFilter extends HttpFilter implements Filter {
      
    
    public AuthFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		System.out.print(username);
		System.out.print(password);
		Cookie[] cookies = req.getCookies();
		boolean isAuthenticated=false;
		if ((username == null || password == null || username.isEmpty() || password.isEmpty()) && cookies != null) {
			
		    if (cookies != null) {
		        for (Cookie cookie : cookies) {
		            if ("auth".equals(cookie.getName()) && "valid".equals(cookie.getValue())) {
		                
		               isAuthenticated=true;
		            }
		        }
		    }
		}
		
		if (isAuthenticated) {
            // User is logged in, allow them to access the requested servlet.
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect them to the login page.
            // Assuming your login page is at /YourProjectName/login.html
            res.sendRedirect(req.getContextPath() + "/login.html");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
