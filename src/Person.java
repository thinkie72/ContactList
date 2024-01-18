public class Person {
    // Instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Accessor methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Overrides toString() in the object class to fit the criteria as specified on canvas
    @Override
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}

