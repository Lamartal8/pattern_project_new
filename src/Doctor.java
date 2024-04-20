package hospital.people;

import utilities.Utils;

public class Doctor {

    public final String[] sexAvailable = new String[] {
        "Male", "Female", "Unknown"
    };

    Utils utils = new Utils();

    private String name;
    private String qualification;
    private String sex;
    private int age;
    private int doctorCode;
    private long contactNumber;

    public Doctor(String name, int sexIndex, String qualification) {
        this.name = name;
        sex = sexAvailable[sexIndex];
        this.age = utils.randInt(25, 70);
        this.qualification = qualification;
        doctorCode = utils.randInt(1000, 9999);
        contactNumber = utils.randLong(7000000000L, 9999999999L);
    }

    public void display() {
        System.out.print(this);
    }

    public String toString() {
        return "Doctor Name: " + name + " (" + qualification + ")" + "\n\tAge: " + age + "\n\tSex: " + sex + "\n\tDoctor's Code: " + doctorCode + "\n\tContact Number: " + contactNumber + "\n";
    }

    public int getDoctorCode() {
        return doctorCode;
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

    public String getQualification() {
        return qualification;
    }
}
