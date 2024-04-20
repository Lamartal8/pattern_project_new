package hospital.people;

import utilities.Utils;

public class Patient {

    public final String[] sexAvailable = new String[] {
        "Male", "Female", "Unknown"
    };

    Utils utils = new Utils();

    //Patient Primary information
    private String name;
    private String sex;
    private int age;
    private long contactNumber;

    //Patient extra information
    private int code;
    private int appointmentCode;
    private int roomNumber;
    private Doctor doctorAppointed;

    public Patient(String name, int sexIndex, int age, long contactNumber, Doctor doctor, int roomNumber) {
        this.name = name;
        sex = sexAvailable[sexIndex];
        this.age = age;
        this.contactNumber = contactNumber;
        // generate a random number between 1 and 1,00,000.
        this.code = utils.randInt(1, 100000);
        // generate a random number between 1 and 1,000.
        this.appointmentCode = utils.randInt(1, 1000);
        this.doctorAppointed = doctor;
        this.roomNumber = roomNumber;
    }

    public void displayMin()   {
        System.out.println("Patient name: " + name + "\tRoom Number: "+roomNumber);
    }

    public void display() {
        System.out.println(this);
    }

    public String toString() {
        return "Patient Name: " + name + "\n\tAge: " + age + "\n\tSex: " + sex + "\n\tPatient's Code: " + code + "\n\tRoom number assigned: " + roomNumber +
        "\nContact number: " + contactNumber + "\nAppointment Code:" + appointmentCode + "\nDoctor assigned:\n" + doctorAppointed;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void updateDoctorAppointed(Doctor doctor) {
        this.doctorAppointed = doctor;
    }

    public int getCode() {
        return code;
    }

    public int getAppointmentCode() {
        return appointmentCode;
    }

    public int getRoomnNumeber() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getSex() {
        return sex;
    }

    public long getContactNumber(){
        return contactNumber;
    }

    public Doctor getDoctor() {
        return doctorAppointed;
    }
}
