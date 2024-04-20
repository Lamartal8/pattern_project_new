package hospital.data;

import hospital.people.Doctor;
import hospital.people.DoctorFactory;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(String name, String sex, int age, String qualification, String type) {
        doctors.add(DoctorFactory.createDoctor(name, sex, age, qualification, type));
    }

    public void display() {
        doctors.forEach(Doctor::display);
    }

    public Doctor getDoctor(int index) {
        return doctors.get(index);
    }

    public int getNumDoctors() {
        return doctors.size();
    }
}
