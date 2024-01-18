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
        int secondInput = s.nextInt();
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
        for(Person contact: contacts) {
            System.out.println(contact);
        }
    }

    // Method sorts Person objects in ContactList depending on specified sort method
    public void sort(int sortBy) {
        // Sorts contacts by first name
        if(sortBy == 0) {
            // Uses bubble sort to shift Person objects until they're in the right order
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    // Creates variables for objects being compared
                    String currentName = contacts.get(j).getFirstName();
                    String nextName = contacts.get(j+1).getFirstName();
                    // Checks lexicographical order of two terms and compares them - substitutes them if they are in the
                    // wrong order
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        // Sets contact to right spot in ArrayList
                        Person a = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, a);
                    }
                }
            }
        }
        // Sorts by last name in lexicographical order (uses similar algorithm to sorting by first name)
        else if(sortBy == 1) {
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts.get(j).getLastName();
                    String nextName = contacts.get(j+1).getLastName();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        Person a = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, a);
                    }
                }
            }
        }
        // Sorts Person objects by phone number
        else if(sortBy == 2) {
            for(int i = 0; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts.get(j).getPhoneNumber();
                    String nextName = contacts.get(j+1).getPhoneNumber();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        Person a = contacts.get(j);
                        contacts.set(j, contacts.get(j+1));
                        contacts.set(j+1, a);
                    }
                }
            }
        }
    }

    // Lists all instances of Students within the ArrayList
    public ArrayList<Person> listStudents() {
        ArrayList<Person> studentList = new ArrayList<Person>();
        for(Person c: contacts) {
            // Checks if each contact in the ContactList is a Student
            if(c instanceof Student){
                // If so, adds them to a new list of only Students
                studentList.add(c);
            }
        }
        // Prints list of all the Student objects within the ContactList
        return studentList;
    }

    // Searches for a specific contact using their first name
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

    // Searches for a specific contact using their last name (uses similar algorithm to searching by first name)
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
        // Declares Scanner and input variables for user input
        Scanner s = new Scanner(System.in);
        int input;
        // Prints message until user inputs correct info
        do {
            System.out.println("Welcome to your Contacts List \nPlease pick from the following menu options");
            System.out.println("1. Add Contact \n2. List All Contacts by First Name \n3. List All Contacts by Last Name" +
                    "\n4. List All Contacts by Phone Number \n5. List All Students \n6. Search by First Name \n7. " +
                    "Search by Last Name \n8. Search By Phone Number \n0. Exit");
            input = s.nextInt();
            // Adds contact to list if user selects that option
            if(input == 1) {
                addContact();
            }
            // Sorts by first name depending
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
            // Lists students
            else if(input == 5) {
                listStudents();
            }
            // Searches by first name using searchByFirstName method and user input
            else if(input == 6) {
                System.out.println("Enter the first name you are searching for: ");
                String after = s.nextLine();
                String enterFirstName = s.nextLine();
                System.out.println(searchByFirstName(enterFirstName));
            }
            // Searches by last name using searchByFirstName method and user input
            else if(input == 7) {
                System.out.println("Enter the last name you are searching for: ");
                String enterLastName = s.nextLine();
                searchByLastName(enterLastName);
            }
            // Searches by phone number using searchByFirstName method and user input
            else if(input == 8) {
                String enterPhoneNum = s.nextLine();
                searchByPhoneNumber(enterPhoneNum);
            }
            // Closes program if user wants to exit code
            } while (input >= 0 && input <= 8);
        }

    public static void main(String[] args) {
        ContactList mine = new ContactList();
        mine.run();
    }
}
