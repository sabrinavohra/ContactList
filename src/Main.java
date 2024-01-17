import java.util.ArrayList;

public class Main {
    Person a = new Student("Sabrina", "Vohra", "6507228395", 11);
    Person b = new Family("Mom", "Vohra", "6507221239", "mom");
    ArrayList<Person> myContacts = new ArrayList<Person>();
    myContacts.add(a);
    myContacts.add(b);
    ContactList mine = new ContactList(myContacts);
    System.out.println(mine);
}
