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
            
        }
    }
}
