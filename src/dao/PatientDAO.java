package dao;
import db.DBConnection;
import model.Patient;
import java.sql.*;
import java.util.*;

public class PatientDAO {
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, age, gender, phone) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.executeUpdate();
            System.out.println("Patient added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("patient_id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("gender"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}