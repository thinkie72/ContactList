public class Student extends Person {
    // Instance variable
    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Accessor method
    public int getGrade() {
        return grade;
    }

    // Overrides Person toString() to add the grade on the end
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
