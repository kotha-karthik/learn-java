
package com.iss.SoapStudent;

public class TestConnection {
    public static void main(String[] args) {
    	 StudentDao dao = new StudentDao();

         // Create a student manually
         Student s = new Student(1, "Karthik", 5000.0);

         // Insert into DB
         boolean result = dao.addStudent(s);

         if (result) {
             System.out.println("✅ Student inserted successfully!");
         } else {
             System.out.println("❌ Failed to insert student.");
         }

         // Fetch all students and print them
         System.out.println("📋 Current students in DB:");
         for (Student st : dao.getStudents()) {
             System.out.println(st.getId() + " | " + st.getName() + " | " + st.getFee());
         }
    }
}
