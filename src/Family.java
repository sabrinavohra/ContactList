public class Family extends Person{
    // Declares extra instance variable for a family member
    private String relation;

    // Constructor that adds relationship to family member alongside Person's instance variables
    public Family(String firstName, String lastName, String phoneNumber, String relation) {
        // Declares Person's instance variables using super
        super(firstName, lastName, phoneNumber);
        this.relation = relation;
    }

    // Returns relationship to contact
    public String getRelation() {
        return this.relation;
    }

    // Overrides Person's toString() method to add relation to user
    @Override
    public String toString() {
        return super.toString() + this.relation;
    }
}
