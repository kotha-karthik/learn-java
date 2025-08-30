package com.example.dao;

import com.example.db.DBConnection;
import com.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT sid, sname, fee FROM Student"; // SQL Server table
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getDouble("fee")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all students", e);
        }
        return list;
    }

    public Student getById(int id) {
        String sql = "SELECT sid, sname, fee FROM student WHERE sid = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("sid"),
                            rs.getString("sname"),
                            rs.getDouble("fee")
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching student by ID", e);
        }
        return null;
    }

    public Student add(Student s) {
        String sql = "INSERT INTO student (sname, fee) VALUES (?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getSname());
            ps.setDouble(2, s.getFee());

            int affected = ps.executeUpdate();
            if (affected == 0) return null;

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    s.setSid(keys.getInt(1)); // SQL Server supports this
                    return s;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding student", e);
        }
        return null;
    }

    public boolean update(Student s) {
        String sql = "UPDATE student SET sname = ?, fee = ? WHERE sid = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, s.getSname());
            ps.setDouble(2, s.getFee());
            ps.setInt(3, s.getSid());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error updating student", e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM student WHERE sid = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting student", e);
        }
    }
}
