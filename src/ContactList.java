public class ContactList {
    private ArrayList<Person> contacts = new ArrayList<Person>();

    public ContactList(ArrayList<Person> people) {
        contacts = people;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add: \n 1. Student \n 2. Family Member");
        String secondInput = s.nextLine();
        System.out.println("Please fill out the following information: ");
        System.out.println("First name: ");
        String firstName = s.nextLine();
        System.out.println("Last name: ");
        String lastName = s.nextLine();
        System.out.println("Phone Number: ");
        String phoneNum = s.nextLine();
        if(secondInput == "1") {
            System.out.println("Grade: ");
            int stuGrade = s.nextInt();
            Person p = new Student(firstName, lastName, phoneNum, stuGrade);
            contacts.add(p);
        }
        else if(secondInput == "2") {
            System.out.println("Relation: ");
            String relation = s.nextLine();
            Person a = new Family(firstName, lastName, phoneNum, relation);
            contacts.add(a);
        }

        else if(secondInput == "3") {

        }
    }

    public void printContacts() {
        for(Person contact: contacts) {
            System.out.println(contact);
        }
    }

    public void run() {
        System.out.println("Welcome to your Contacts List \n Please pick from the following menu options");
        Scanner s = new Scanner(System.in);
        System.out.println("1. Add Contact \n 2. List All Contacts by First Name \n 3. List All Contacts by Last Name" +
                "\n 4. List All Contacts by Phone Number \n 5. List All Students \n 6. Search by First Name \n 7. " +
                "Search by Last Name \n 8. Search By Phone Number \n 0. Exit");
        String input = s.nextLine();
        if(input == "1") {
            addContact();
        }
        if(input == "2") {

        }
    }

    public void sort(int sortBy) {
        if(sortBy == 0) {
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts[j].getFirstName();
                    String nextName = contacts[j+1].getFirstName();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts[j] = contacts[j+1];
                    }
                }
            }
        }
        else if(sortBy == 1) {
            for(int i = 1; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts[j].getLastName();
                    String nextName = contacts[j+1].getLastName();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts[j] = contacts[j+1];
                    }
                }
            }
        }
        else if(sortBy == 2) {
            for(int i = 0; i < contacts.size() - 1; i++) {
                for(int j = 0; j < contacts.size() - i; j++) {
                    String currentName = contacts[j].getPhoneNumber();
                    String nextName = contacts[j+1].getPhoneNumber();
                    if(currentName.compareToIgnoreCase(nextName) <= -1) {
                        contacts[j] = contacts[j+1];
                    }
                }
            }
        }
    }


}
