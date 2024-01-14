public class Family extends Person{
    private String relation;
    public Family(String firstName, String lastName, String phoneNumber, String relation) {
        super(firstName, lastName, phoneNumber);
        this.relation = relation;
    }

    public String getRelation() {
        return this.relation;
    }

    public String toString() {
        return super.toString() + this.relation;
    }
}
