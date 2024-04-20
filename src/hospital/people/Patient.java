package hospital.people;

import utilities.Utils;

public class Patient {
    private String name;
    private String sex;
    private int age;
    private long contactNumber;
    private int code;
    private int appointmentCode;
    private int roomNumber;
    private Doctor doctorAppointed;

    public Patient(String name, String sex, int age, long contactNumber, Doctor doctor, int roomNumber) {
        Utils utils = Utils.getInstance();
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.contactNumber = contactNumber;
        this.doctorAppointed = doctor;
        this.roomNumber = roomNumber;
        this.code = utils.randInt(10000, 99999);  // Unique patient code
        this.appointmentCode = utils.randInt(1000, 9999);  // Unique appointment code
    }

    public void display() {
        System.out.println("Patient Name: " + name + ", Sex: " + sex + ", Age: " + age +
                           ", Contact Number: " + contactNumber + ", Room: " + roomNumber +
                           ", Doctor: " + (doctorAppointed != null ? doctorAppointed.toString() : "No doctor assigned"));
    }

    // Additional methods...
}
