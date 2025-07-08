package model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String phone;

    public Doctor(){}
    public Doctor(String name, String specialization, String phone)
    {
    	this.name =name;
    	this.specialization = specialization;
    	this.phone = phone;
    }
    
    public Doctor(int id, String name, String specialization, String phone)
    {
    	this(name, specialization, phone);
    	this.id = id;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getPhone() { return phone; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setPhone(String phone) { this.phone = phone; }
}
