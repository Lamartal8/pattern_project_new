package hospital.people;

public abstract class Doctor {
    private String name;
    private String sex;
    private int age;
    private String qualification;

    public Doctor(String name, String sex, int age, String qualification) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Doctor Name: " + name + ", Sex: " + sex + ", Age: " + age + ", Qualification: " + qualification;
    }
   
    public void display() {
        System.out.println(this);
    }
}
