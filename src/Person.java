public class Person {
    // Declares instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Creates constructor with instance variables
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber =  phoneNumber;
    }

    // Returns first name of Person
    public String getFirstName() {
        return firstName;
    }

    // Returns last name of Person
    public String getLastName() {
        return lastName;
    }

    // Returns phone number of Person
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString() method for Person that prints, "firstname lastname - #phone number"
    public String toString() {
        return this.firstName + " " + this.lastName + " - #" + this.phoneNumber + " ";
    }
}
