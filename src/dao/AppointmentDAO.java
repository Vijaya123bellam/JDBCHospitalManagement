package dao;
import db.DBConnection;
import model.Appointment;
import java.sql.*;
import java.util.*;

public class AppointmentDAO {
    public void addAppointment(Appointment a) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, notes) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setString(3, a.getAppointmentDate());
            ps.setString(4, a.getNotes());
            ps.executeUpdate();
            System.out.println("Appointment scheduled.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Appointment(rs.getInt("appointment_id"), rs.getInt("patient_id"),
                        rs.getInt("doctor_id"), rs.getString("appointment_date"), rs.getString("notes")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}