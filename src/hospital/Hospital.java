package hospital;

import hospital.data.DoctorList;
import hospital.people.*;
import utilities.Utils;
import java.util.Scanner;

public class Hospital {
    private DoctorList doctorList;
    private Patient[] patients;
    private int roomAssigned;
    private Scanner scanner;

    public Hospital() {
        this.doctorList = new DoctorList();
        this.patients = new Patient[200];
        this.roomAssigned = 0;
        this.scanner = new Scanner(System.in);
        initializeDoctors();
    }

    private void initializeDoctors() {
       
        doctorList.addDoctor("Dr. Alice Smith", "FEMALE",  40, "MBBS", "SU");
        doctorList.addDoctor("Dr. Bob Johnson", "MALE", 55,  "MBBS, MD", "GP" );
        doctorList.addDoctor("Dr. Carol Taylor", "FEMALE", 39,  "MBBS, MD Pediatrics", "PE");
    }

    public void addPatient() {
        if (roomAssigned >= patients.length) {
            System.out.println("No more rooms available.");
            return;
        }

        System.out.println("Enter Patient Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left behind
        System.out.print("Sex (Male, Female, Other): ");
        String sex = scanner.nextLine();
        System.out.print("Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline left behind

        System.out.println("Select Doctor (index):");
        doctorList.display();
        int docIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline left behind
        Doctor doctor = doctorList.getDoctor(docIndex);

        patients[roomAssigned] = new Patient(name, sex, age, contactNumber, doctor, roomAssigned + 1);
        roomAssigned++;
        System.out.println("Patient successfully added to room number " + roomAssigned + ".");
    }

    public void displayPatients() {
        if (roomAssigned == 0) {
            System.out.println("There are no patients currently admitted.");
            return;
        }
        for (Patient patient : patients) {
            if (patient != null) {
                patient.display();
            }
        }
    }

    public void removePatient() {
        System.out.print("Enter room number to remove patient from (1 to " + roomAssigned + "): ");
        int room = scanner.nextInt() - 1;
        if (room >= 0 && room < roomAssigned && patients[room] != null) {
            patients[room] = null;
            System.out.println("Patient removed from room " + (room + 1) + ".");
            roomAssigned--;  // Adjust roomAssigned count after removal
        } else {
            System.out.println("Invalid room number or room already empty.");
        }
    }

    public void displayDoctors() {
        doctorList.display();
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Remove Patient");
            System.out.println("4. Exit");
            System.out.print("Option: ");
            int choice = hospital.scanner.nextInt();
            hospital.scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    hospital.addPatient();
                    break;
                case 2:
                    hospital.displayPatients();
                    break;
                case 3:
                    hospital.removePatient();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        hospital.scanner.close();
    }
}
