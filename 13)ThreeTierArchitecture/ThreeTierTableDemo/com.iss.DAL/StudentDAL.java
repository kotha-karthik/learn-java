package com.iss.DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.iss.models.Studentinfo;


public class StudentDAL {
    private Connection con;

    public StudentDAL() {
        try {
            con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\sqlexpress;databaseName=studentdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean add(Studentinfo s) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO studentinfo VALUES (?, ?, ?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDouble(3, s.getFee());
            ps.setBytes(4, s.getPhoto());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Studentinfo s) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE studentinfo SET sname = ?, fee = ? WHERE sno = ?");
            ps.setString(1, s.getName());
            ps.setDouble(2, s.getFee());
            ps.setInt(3, s.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int sno) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM studentinfo WHERE sno = ?");
            ps.setInt(1, sno);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Studentinfo> getAll() {
        List<Studentinfo> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM studentinfo");
            while (rs.next()) {
                Studentinfo s = new Studentinfo();
                s.setId(rs.getInt("sno"));
                s.setName(rs.getString("sname"));
                s.setFee(rs.getDouble("fee"));
                s.setPhoto(rs.getBytes("photo"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
