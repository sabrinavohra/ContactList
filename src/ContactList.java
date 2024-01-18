import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: \n 1. Student \n 2. Family Member");
        int secondInput = s.nextInt();
        System.out.println("Please fill out the following information: ");
        System.out.println("First name: ");
        String firstName = s.nextLine();
        System.out.println("Last name: ");
        String lastName = s.nextLine();
        System.out.println("Phone Number: ");
        String phoneNum = s.nextLine();
        if(secondInput == 1) {
            System.out.println("Grade: ");
            int stuGrade = s.nextInt();
            Person p = new Student(firstName, lastName, phoneNum, stuGrade);
            contacts.add(p);
        }
        else if(secondInput == 2) {
            System.out.println("Relation: ");
            String relation = s.nextLine();
            Person a = new Family(firstName, lastName, phoneNum, relation);
            contacts.add(a);
        }
    }

    public void printContacts() {
        for(Person contact: contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        if(sortBy == 0) {
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts.get(j).getFirstName();
                    String nextName = contacts.get(j+1).getFirstName();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts.set(j, contacts.get(j+1));
                    }
                }
            }
        }
        else if(sortBy == 1) {
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts.get(j).getLastName();
                    String nextName = contacts.get(j+1).getLastName();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts.set(j, contacts.get(j+1));
                    }
                }
            }
        }
        else if(sortBy == 2) {
            for(int i = 0; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts.get(j).getPhoneNumber();
                    String nextName = contacts.get(j+1).getPhoneNumber();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts.set(j, contacts.get(j+1));
                    }
                }
            }
        }
    }

    public ArrayList<Person> listStudents() {
        ArrayList<Person> studentList = new ArrayList<Person>();
        for(Person c: contacts) {
            if(c instanceof Student){
                studentList.add(c);
            }
        }
        return studentList;
    }

    public Person searchByFirstName(String firstName) {
        for(Person c: contacts) {
            if(c.getFirstName() == firstName) {
                return c;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for(Person c: contacts) {
            if(c.getLastName() == lastName) {
                return c;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for(Person c: contacts) {
            if(c.getPhoneNumber() == phoneNumber) {
                return c;
            }
        }
        return null;
    }
    public void run() {
        Scanner s = new Scanner(System.in);
        int input;
        do {
            System.out.println("Welcome to your Contacts List \n Please pick from the following menu options");
            System.out.println("1. Add Contact \n 2. List All Contacts by First Name \n 3. List All Contacts by Last Name" +
                    "\n 4. List All Contacts by Phone Number \n 5. List All Students \n 6. Search by First Name \n 7. " +
                    "Search by Last Name \n 8. Search By Phone Number \n 0. Exit");
            input = s.nextInt();
        } while(input == null);
        if(input == 1) {
            addContact();
        }
        else if(input == 2) {
            sort(0);
        }
        else if(input == 3) {
            sort(1);
        }
        else if(input == 4) {
            sort(2);
        }
        else if(input == 5) {
            listStudents();
        }
        else if(input == 6) {
            String enterFirstName = s.nextLine();
            searchByFirstName(enterFirstName);
        }
        else if(input == 7) {
            String enterLastName = s.nextLine();
            searchByLastName(enterLastName);
        }
        else if(input == 8) {
            String enterPhoneNum = s.nextLine();
            searchByPhoneNumber(enterPhoneNum);
        }
        else if(input == 0) {
            return;
        }
    }
}
