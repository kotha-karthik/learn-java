package com.project.DemoApp;

//import java.lang.module.Configuration;
import org.hibernate.cfg.Configuration; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure("src/main/resources/hibernate.cfg.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	    Session session = factory.openSession();
	    Product p=new Product();
	    p.setName("Dell");
	    p.setProduct_id(2024);
	    p.setPrice(500.50);
	    Transaction transaction = session.beginTransaction();
	
	    session.persist(p);
	    transaction.commit();
	
	    session.close();
	    factory.close();
    }
}
