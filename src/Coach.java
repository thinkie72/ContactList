public class Coach extends Person {
    // Instance variable
    private String sport;

    // Constructor
    public Coach(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    // Accessor method
    public String getSport() {
        return sport;
    }

    // Overrides person toString to add the sport on the end
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}
