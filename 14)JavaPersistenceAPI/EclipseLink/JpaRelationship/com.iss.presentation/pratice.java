package com.iss.presentation;

import java.util.Arrays;

import com.iss.models.Address;
import com.iss.models.Department;

import com.iss.models.EmployeeInfov2;
import com.iss.models.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class pratice 
{
	public static void main(String args[])
	{
		
		try{
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		
	      
		    EntityManager em = emf.createEntityManager( );
		    em.getTransaction().begin();
		    Department dept1 = new Department();
            dept1.setName("Engineering");

            Department dept2 = new Department();
            dept2.setName("Marketing");

            em.persist(dept1);
            em.persist(dept2);

            // Create Address
            Address addr1 = new Address();
            addr1.setCity("Hyderabad");
            addr1.setState("Telangana");

            Address addr2 = new Address();
            addr2.setCity("Bangalore");
            addr2.setState("Karnataka");

            // Create Projects
            Project project1 = new Project();
            project1.setProjectName("AI Analytics Platform");

            Project project2 = new Project();
            project2.setProjectName("Marketing Automation System");

            em.persist(project1);
            em.persist(project2);

            // Create Employee 1
            EmployeeInfov2 emp1 = new EmployeeInfov2();
            emp1.setEmpid(101);
            emp1.setEmpname("Alice");
            emp1.setSalary(75000);
            emp1.setEmpdep("Engineering");
            emp1.setAddress(addr1);
            emp1.setDepartment(dept1);
            emp1.setProjects(Arrays.asList(project1, project2));

            // Create Employee 2
            EmployeeInfov2 emp2 = new EmployeeInfov2();
            emp2.setEmpid(102);
            emp2.setEmpname("Bob");
            emp2.setSalary(65000);
            emp2.setEmpdep("Marketing");
            emp2.setAddress(addr2);
            emp2.setDepartment(dept2);
            emp2.setProjects(Arrays.asList(project2));

            // Link employees to department
            dept1.setEmployeelist(Arrays.asList(emp1));
            dept2.setEmployeelist(Arrays.asList(emp2));

            // Persist employees
            em.persist(emp1);
            em.persist(emp2);

            em.getTransaction().commit();
            System.out.println("Data inserted successfully!");
		    
		    
		    
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	    
		
	}

}
