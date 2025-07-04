package com.iss.BLL;


import java.util.List;

import com.iss.DAL.StudentDAL;
import com.iss.models.Studentinfo;

public class StudentBLL {
    // Create an instance of the Data Access Layer
    private StudentDAL dal;

    public StudentBLL() {
        dal = new StudentDAL();
    }

    // Add student (calls DAL)
    public boolean addStudent(Studentinfo s) {
        return dal.add(s);
    }

    // Update student
    public boolean updateStudent(Studentinfo s) {
        return dal.update(s);
    }

    // Delete student
    public boolean deleteStudent(int sno) {
        return dal.delete(sno);
    }

    // Get all students from DB
    public List<Studentinfo> getAllStudents() {
        return dal.getAll();
    }
}
