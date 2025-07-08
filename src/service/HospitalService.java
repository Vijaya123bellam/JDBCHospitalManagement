package service;
import dao.*;
import model.*;
import java.util.*;

public class HospitalService {
    private final Scanner sc = new Scanner(System.in);
    private final DoctorDAO doctorDAO = new DoctorDAO();
    private final PatientDAO patientDAO = new PatientDAO();
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void menu() {
        while (true) {
            System.out.println("\n--- Hospital Management ---");
            System.out.println("1. Add Doctor\n2. Add Patient\n3. Schedule Appointment\n4. View Doctors\n5. View Patients\n6. View Appointments\n7. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> addPatient();
                case 3 -> scheduleAppointment();
                case 4 -> viewDoctors();
                case 5 -> viewPatients();
                case 6 -> viewAppointments();
                case 7 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addDoctor() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String spec = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        doctorDAO.addDoctor(new Doctor(0, name, spec, phone));
    }

    private void addPatient() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        patientDAO.addPatient(new Patient(0, name, age, gender, phone));
    }

    private void scheduleAppointment() {
        System.out.print("Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Notes: ");
        String notes = sc.nextLine();
        appointmentDAO.addAppointment(new Appointment(0, pid, did, date, notes));
    }

    private void viewDoctors() {
        for (Doctor d : doctorDAO.getAllDoctors())
            System.out.println(d.getId() + " - " + d.getName() + " (" + d.getSpecialization() + ")");
    }

    private void viewPatients() {
        for (Patient p : patientDAO.getAllPatients())
            System.out.println(p.getId() + " - " + p.getName() + ", " + p.getAge() + ", " + p.getGender());
    }

    private void viewAppointments() {
        for (Appointment a : appointmentDAO.getAllAppointments())
            System.out.println("Appointment ID: " + a.getId() + " | Patient: " + a.getPatientId()
                    + " | Doctor: " + a.getDoctorId() + " | Date: " + a.getAppointmentDate());
    }
}