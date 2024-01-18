public class Student extends Person {
    // Declares added instance variable for Student
    private int grade;

    // Constructor for Person instance variables and added grade variable
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        // Uses variables from superclass
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Returns grade of Student
    public int getGrade() {
        return grade;
    }

    // Overrides Person's toString() method and adds the grade level of the Student
    @Override
    public String toString() {
        return super.toString() + "Grade: " + this.grade;
    }
}
