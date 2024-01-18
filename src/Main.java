import java.util.ArrayList;

public class Main {
    ArrayList<Person> myContacts = new ArrayList<Person>();
    Person a = new Student("Sabrina", "Vohra", "6507228395", 11);
    Person b = new Family("Mom", "Vohra", "6507221239", "mom");
    myContacts.add(a);
    myContacts.add(b);
    ContactList mine = new ContactList();
    mine.run();
}
