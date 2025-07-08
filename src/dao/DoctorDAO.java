package dao;
import db.DBConnection;
import model.Doctor;
import java.sql.*;
import java.util.*;

public class DoctorDAO {
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (name, specialization, phone) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.executeUpdate();
            System.out.println("Doctor added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Doctor(rs.getInt("doctor_id"), rs.getString("name"),
                        rs.getString("specialization"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}