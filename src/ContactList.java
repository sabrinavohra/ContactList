import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Declares ArrayList of Person objects to use as the contact list
    private ArrayList<Person> contacts;

    // Constructor for ContactList that initializes ArrayList of Person objects
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Returns the ContactList
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Method to add a Contact to the ContactList
    public void addContact() {
        Scanner s = new Scanner(System.in);
        // Asks what kind of contact to add
        System.out.println("Select a type of contact to add: \n1. Student \n2. Family Member");
        // Saves user input for future use
        int secondInput = s.nextInt();
        // Creates new line so input will run
        String next = s.nextLine();
        // Asks for information about contact in order to create the profile
        System.out.println("Please fill out the following information: ");
        System.out.println("First name: ");
        String firstName = s.nextLine();
        System.out.println("Last name: ");
        String lastName = s.nextLine();
        System.out.println("Phone Number: ");
        String phoneNum = s.nextLine();
        // Adds grade info if contact is a Student
        if(secondInput == 1) {
            System.out.println("Grade: ");
            int stuGrade = s.nextInt();
            Person p = new Student(firstName, lastName, phoneNum, stuGrade);
            contacts.add(p);
        }
        // Adds relationship info if contact is a Family member
        else if(secondInput == 2) {
            System.out.println("Relation: ");
            String relation = s.nextLine();
            Person a = new Family(firstName, lastName, phoneNum, relation);
            contacts.add(a);
        }
    }

    // Prints out list of contacts
    public void printContacts() {
        // Iterates through the list of contacts and prints each one
        for(Person contact: contacts) {
            System.out.println(contact);
        }
    }

    // Method sorts Person objects in ContactList depending on specified sort method
    public void sort(int sortBy) {
        // Initializes variable for positive/negative value of comparison using compareTo()
        int compare = 0;
        // Iterates through contact list
        for(int i = 0; i < contacts.size() - 1; i++) {
            // Iterates the number of times necessary to check and compare each contact
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                // Creates variables for current Person being checked and the next person in the ArrayList
                Person a = contacts.get(j);
                Person b = contacts.get(j+1);
                // Sorts by first name
                if(sortBy == 0) {
                    // Creates variables for first names of Person a and b
                    String first = a.getFirstName();
                    String second = b.getFirstName();
                    // Sets compare to the lexicographical difference between Person a and b's first names
                        // Will be positive if switch is required
                    compare = first.compareToIgnoreCase(second);
                }
                // Sorts by last name
                else if(sortBy == 1) {
                    String first = a.getLastName();
                    String second = b.getLastName();
                    compare = first.compareToIgnoreCase(second);
                }
                // Sorts by phone number
                else if(sortBy == 2) {
                    String first = a.getPhoneNumber();
                    String second = b.getPhoneNumber();
                    compare = first.compareToIgnoreCase(second);
                }
                // Uses compare that has values from within if and else if statements to switch order of contacts if
                // necessary
                if(compare > 0) {
                    Person c = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1, c);
                }
            }
        }
        // Prints out list of contacts after running through all
        printContacts();
    }

    // Lists all instances of Students within the ArrayList
    public ArrayList<Person> listStudents() {
        // Creates new ArrayList to hold contacts of only students
        ArrayList<Person> studentList = new ArrayList<Person>();
        for(Person c: contacts) {
            // Checks if each contact in the ContactList is a Student
            if(c instanceof Student){
                // If so, adds them to the list of only Students
                studentList.add(c);
            }
        }
        // Returns list of all the Student objects within the ContactList
        return studentList;
    }

    // Searches for a contact using their first name
    public Person searchByFirstName(String firstName) {
        // Checks each Person within ContactList to see if their first name matches with the one being searched for
        for(Person c: contacts) {
            // If it does, the Person is returned
            if(c.getFirstName().equals(firstName)) {
                return c;
            }
        }
        // If the person is not in the ContactList, the method returns null
        return null;
    }

    // Searches for a contact using their last name (uses similar algorithm as searching by first name)
    public Person searchByLastName(String lastName) {
        for(Person c: contacts) {
            if(c.getLastName().equals(lastName)) {
                return c;
            }
        }
        return null;
    }

    // Searches for a specific contact using their phone number (uses similar algorithm to searching by phone number)
    public Person searchByPhoneNumber(String phoneNumber) {
        for(Person c: contacts) {
            if(c.getPhoneNumber().equals(phoneNumber)) {
                return c;
            }
        }
        return null;
    }

    // Runs code
    public void run() {
        // Declares Scanner and input variable for user input
        Scanner s = new Scanner(System.in);
        int input;
        // Prints message until user inputs correct info and reruns program until user exits
        do {
            System.out.println("Welcome to your Contacts List \nPlease pick from the following menu options");
            System.out.println("1. Add Contact \n2. List All Contacts by First Name \n3. List All Contacts by Last Name" +
                    "\n4. List All Contacts by Phone Number \n5. List All Students \n6. Search by First Name \n7. " +
                    "Search by Last Name \n8. Search By Phone Number \n0. Exit");
            input = s.nextInt();
            // Uses nextLine so user input will work for later if statements
            String after = s.nextLine();
            // Adds contact to list
            if(input == 1) {
                addContact();
            }
            // Sorts by first name
            else if(input == 2) {
                sort(0);
            }
            // Sorts by last name
            else if(input == 3) {
                sort(1);
            }
            // Sorts by phone number
            else if(input == 4) {
                sort(2);
            }
            // Prints list of only students
            else if(input == 5) {
                System.out.println(listStudents());
            }
            // Searches by first name using searchByFirstName method and user input
            else if(input == 6) {
                System.out.println("Enter the first name you are searching for: ");
                String enterFirstName = s.nextLine();
                // Calls method using user input
                System.out.println(searchByFirstName(enterFirstName));
            }
            // Searches by last name using searchByLastName method and user input
            else if(input == 7) {
                System.out.println("Enter the last name you are searching for: ");
                String enterLastName = s.nextLine();
                System.out.println(searchByLastName(enterLastName));
            }
            // Searches by phone number using searchByPhoneNum method and user input
            else if(input == 8) {
                System.out.println("Enter the phone number you are searching for: ");
                String enterPhoneNum = s.nextLine();
                System.out.println(searchByPhoneNumber(enterPhoneNum));
            }
            // Closes program if user wants to exit code or if they input an invalid number
            } while (input > 0 && input <= 8);
        }

    // Runs program
    public static void main(String[] args) {
        // Creates instance of a ContactList
        ContactList mine = new ContactList();
        // Calls run method on the instance of the ContactList
        mine.run();
    }
}
