package com.iss.DAL;

import java.util.List;

import com.iss.models.EmployeeInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDAL 
{
	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
    
    private EntityManager entitymanager = emfactory.createEntityManager( );
	
	public boolean add(EmployeeInfo emp)
    {
		try 
		{
	    	entitymanager.getTransaction().begin();
	    	entitymanager.persist(emp);// to add the record
	    	entitymanager.getTransaction().commit();
	    	return true;
		}catch(Exception ex)
		{
			throw ex;
			
		}
    }
	public boolean update(EmployeeInfo emp)
    {
		try 
		{
	    	entitymanager.getTransaction().begin();
	        entitymanager.merge(emp); // Use merge for update
	        entitymanager.getTransaction().commit();
	        return true;
		}catch(Exception ex)
		{
			throw ex;
		}
    }
	public boolean delete(int empid) {
		try
		{
	        entitymanager.getTransaction().begin();
	        EmployeeInfo emp = entitymanager.find(EmployeeInfo.class, empid);
	        if (emp != null) {
	            entitymanager.remove(emp);
	        }
	        entitymanager.getTransaction().commit();
	        return true;
		}catch(Exception ex)
		{
			throw ex;
		}
    }

    public List<EmployeeInfo> getAll() {
        return entitymanager.createQuery("SELECT s FROM EmployeeInfo s", EmployeeInfo.class).getResultList();
    }

    public EmployeeInfo getById(int empid) {
        return entitymanager.find(EmployeeInfo.class,empid);
    }
    
    

}
