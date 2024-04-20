
package hospital.people;


public class DoctorFactory {
    
    public static Doctor createDoctor(String name, String sex, int age, String qualification, String type) {
         
        switch (type) {
            case "SU":
                return new SurgeonDoctor(name, sex, age, qualification);
            case"GP": 
                return new GeneralPractitionerDoctor(name, sex, age, qualification);
            case"PE":
                return new PediatricianDoctor(name, sex, age, qualification);
            default:
                throw new AssertionError();
        }
    }
}
