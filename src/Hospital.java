package hospital;

import hospital.people.Patient;
import hospital.people.Doctor;
import hospital.data.DoctorList;
import java.util.Scanner;

public class Hospital {

    private final int maxRoom = 200; //Maximun room in the hospital
    DoctorList dl = new DoctorList();
    Patient patients[] = new Patient[maxRoom]; //Array of patients
    Scanner scn = new Scanner(System.in); //to get object from user
    int roomAssigned = 0; //holds the number of room assigned

    public void  addPatient() {
        if (roomAssigned == maxRoom) {
            System.out.println("No Room Available!"); //print error message
            return;
        }
        int sex = -1, age, room  = -1, doc = -1;

        System.out.print("Enter Patient Name: ");
        String name = scn.next();

        System.out.print("Enter Patient age: ");
        age = scn.nextInt();

        //get valid sex
        do {
            if(sex != -1) System.out.println("Select a Sex!");
            System.out.print("Enter Patient's sex (1 => Male  2 => Female  3 => Unknown): ");
            sex = scn.nextInt() - 1;
        } while (sex > 2 || sex < 0);

        //get valid room number
        do {
            if(room != -1) System.out.println("Room Not Available!");
            System.out.print("Enter Patient's room number(1 - " + maxRoom + "): ");
            room = scn.nextInt() - 1;
        } while (room > maxRoom || room < 0);

        //get valid doctor
        do {
            if(doc != -1)
                System.out.println("Enter Valid Doctor's index");
            if(doc == -1) dl.display();
            System.out.print("Select Doctor which is to be appointed: ");
            doc = scn.nextInt();
        } while (doc > dl.getNumDoctor() || doc < 0);

        System.out.print("Enter Patient's contact number: ");
        long contactNumber = scn.nextLong();

        patients[room] = new Patient(name, sex, age, contactNumber, dl.getDoctor(doc), room + 1);

        roomAssigned++; //increse number of room by 1
    }

    public void viewPatient() {
        if(roomAssigned == 0){
            System.out.println("NO Patient Available!");
            return;
        }
        int room = -1;
        do {
            if(room != -1)
                System.out.println("Room Not Available!");
            System.out.print("Enter Patient room number of patient to view (0 for all patient): ");
            room = scn.nextInt();
        } while (room > maxRoom || room < 0);

        //display minimal information of all patient
        if(room == 0)
            for (int i = 0; i < maxRoom; i++) {
                if (patients[i] != null)
                    patients[i].displayMin(); //display only valuabe information to save space on console (terminal) (cmd promt)
            }
        else if(patients[room - 1] == null)
            System.out.println("Room is Empty");
        else patients[room - 1].display();
    }

    public void displayDocs() {
        dl.display();
    }

    public void removePatient() {
        if(roomAssigned == 0){
            System.out.println("NO Patient Available!");
            return;
        }

        int room = -1;

        do {
            if(room != -1)
                System.out.println("Room Not Available!");
            System.out.print("Enter Patient room number of patient to remove (0 to remove all patient i.e. reset Hospital): ");
            room = scn.nextInt();
        } while (room > maxRoom || room < 0);

        if (room == 0) {
            System.out.print("Write \"CONFIRM\" to reset: ");
            String s = scn.next();
            if(s.equals("CONFIRM"))
                patients = new Patient[maxRoom];
        } else if(patients[room - 1] == null) {
            System.out.println("Room is already Empty!");
            return;
        } else {
            patients[room - 1] = null; //room emptied
            System.out.println("Room is Emptied");
        }

        roomAssigned--; //decrease number of patient
    }

    public void updatePatient() {
        if(roomAssigned == 0){
            System.out.println("NO Patient Available!");
            return;
        }
        int room = -1 , c, nRoom = -1;
        //repeat unti user enters valid room
        do {
            if(room != -1)
                System.out.println("Room Not Available!");
            System.out.print("Enter Patient room number of patient to Edit: ");
            room = scn.nextInt() - 1;
        } while (room > maxRoom || room < 0);

        if (patients[room] == null) {
            System.out.println("Room is Empty!");
            return;
        }
        //Show choices
        System.out.println("Edits Available:");
        System.out.println("1 => Update Name\t\t2 => Update Room number\n3 => Update appointed doctor");
        System.out.print("Select choice:");
        c = scn.nextInt();//get choice
        switch (c) {
            case 1:
                System.out.print("Enter new Name: ");
                String s = scn.next(); //get new name from the user
                System.out.println("\"" + s + "\" will replace \"" + patients[room].getName() + "\"");
                patients[room].updateName(s); //update instance variable
                break;
            case 2:
                do {
                    if(nRoom != -1)
                        System.out.println("Room not Available!");
                    System.out.print("Enter new room number: ");
                    nRoom = scn.nextInt() - 1;
                    if(patients[nRoom] != null) {
                        System.out.println("Room is not Empty!");
                        nRoom = 201;
                    }
                } while (nRoom < 0 || nRoom > 200);
                System.out.println("\"" + (nRoom + 1) + "\" will replace \"" + (room + 1) + "\"");
                patients[nRoom] = patients[room]; //Assign new room to patient
                patients[room] = null; //Empty previous room
                patients[nRoom].updateRoomNumber(nRoom + 1); //update instance variable
                break;
            case 3:
                int doc = -1;
                do {
                    if(doc != -1)
                        System.out.println("Enter Valid Doctor's index");
                    if(doc == -1) dl.display();
                    System.out.print("Select Doctor which is to be appointed: ");
                    doc = scn.nextInt();
                } while (doc > dl.getNumDoctor() || doc < 0);
                patients[room].updateDoctorAppointed(dl.getDoctor(doc));
                break;
            default:
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Hospital h = new Hospital();
        int c = 0;
        while(c != -1) {
            System.out.println("Tasks Available: ");
            System.out.println("\t1 => Add Patient\t2 => Remove Patient\n\t3 => View Patient\t4 => View Doctors\n\t5 => Update Patent\t6 => Exit");
            System.out.print("Enter Choice: ");
            c = scn.nextInt();
            switch (c) {
                case 1:
                    h.addPatient();
                    break;
                case 2:
                    h.removePatient();
                    break;
                case 3:
                    h.viewPatient();
                    break;
                case 4:
                    h.displayDocs();
                    break;
                case 5:
                    h.updatePatient();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    c = -1;
                    break;
                default:
                    System.out.println("Select A valid Option!");
            }
            System.out.println();
        }
    }

}
