package com.iss.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ContextSessonListener
 *
 */
public class ContextSessonListener implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ContextSessonListener() {
        // TODO Auto-generated constructor stub
    }
    
    public void sessionCreated(HttpSessionEvent se) 
    {
    	se.getSession().setAttribute("Message","Hello");
    	//se.getSession().setMaxInactiveInterval(10);
    	System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent se) 
    {
    	 System.out.println("Session Destroyed");
    }
    
    public void contextInitialized(ServletContextEvent sce) {
    	sce.getServletContext().setAttribute("Counter",1);
    	System.out.println("Context Created");
    }
    public void contextDestroyed(ServletContextEvent sce) {

    	System.out.println("Context Destroyed");
    }
}
