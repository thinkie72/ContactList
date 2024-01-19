import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance variable
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Accessor method
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Method to add a given Person to contacts
    public void addContact(Person p) {
        contacts.add(p);
    }

    // Prints contacts by printing each person in contacts on their own line using a for each loop
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    // Uses bubble sort to sort the contacts by attribute
    public void sort(int sortBy) {
        String s1;
        String s2;
        // Size variable to prevent the need to call size() on every iteration
        int size = contacts.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // If statements to find the attribute to sort by, based on its number on the menu
                if (sortBy == 2) {
                    s1 = contacts.get(j).getFirstName();
                    s2 = contacts.get(j + 1).getFirstName();
                } else if (sortBy == 3) {
                    s1 = contacts.get(j).getLastName();
                    s2 = contacts.get(j + 1).getLastName();
                } else {
                    s1 = contacts.get(j).getPhoneNumber();
                    s2 = contacts.get(j + 1).getPhoneNumber();
                }
                // Compares s1 to s2 after the values are found based on the selected menu item
                if (s1.compareTo(s2) > 0)
                    swap(j);
            }
        }
    }

    // Simple sorting algorithm (using a third bucket) to prevent repeated code
    public void swap(int index) {
        // The "third bucket"
        Person temp = contacts.get(index);
        // Moves the value of the lesser attribute up
        contacts.set(index, contacts.get(index + 1));
        // Places the value of the greater value in temp at the next index, completing the swap
        contacts.set(index + 1, temp);
    }

    // Searching method to find a Person with the same first name
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName))
                return p;
        }
        return null;
    }

    // Searching method to find a Person with the same last name
    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName))
                return p;
        }
        return null;
    }

    // Searching method to find a Person with the same phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber))
                return p;
        }
        return null;
    }

    // Lists the contacts who are Students
    public void listStudents() {
        for (Person p : contacts) {
            // Sees if the Person is also a Student
            if (p instanceof Student)
                System.out.println(p);
        }
    }

    // Prints the entire menu for possible actions with the contact list
    public void printMenu() {
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last " +
                "Name\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First " +
                "Name\n7. Search By Last Name\n8. Search By Phone Number\n0. Exit");
    }

    // Runs through all user prompts, and keeps running until an exit
    public void run() {
        printMenu();
        Scanner s = new Scanner(System.in);
        // Int to hold the value of the menu selection
        int num = s.nextInt();
        s.nextLine();
        if (num == 1) {
            // Creates a contact and adds it to the list
            createContact();
        } else if (num >= 2 && num <= 4) {
            // Sorts and prints the contacts by attribute
            sort(num);
            for (Person p : contacts) {
                System.out.println(p);
            }
        } else if (num == 5) {
            // Simply lists the students
            listStudents();
        } else if (num >= 6 && num <= 8) {
            // Searches for a Person with an identical attribute
            search(num);
        } else {
            // Only way to exit the contacts page
            return;
        }
        // recursive step to continue running the method until an exit
        run();
    }

    // Determines the value that needs to be searched for within contacts
    public void search(int num) {
        Scanner s = new Scanner(System.in);
        // Person with the desired identical attribute
        Person p;
        // The desired attribute
        String str;
        // Ask for the desired attribute and begin searching algorithms
        if (num == 6) {
            System.out.println("Enter a first name:");
            str = s.nextLine();
            p = searchByFirstName(str);
        } else if (num == 7) {
            System.out.println("Enter a last name:");
            str = s.nextLine();
            p = searchByLastName(str);
        } else {
            System.out.println("Enter a phone number:");
            str = s.nextLine();
            p = searchByPhoneNumber(str);
        }
        // Checks if anyone actually has the desired attribute, and then prints them out
        if (p == null) {
            System.out.println(str + " is not in the list.");
        } else {
            System.out.println(p);
        }
    }

    // Begins the process of creating and adding a new contact, before actually calling the addContact() method
    public void createContact() {
        Scanner s = new Scanner(System.in);
        // Asks for the "type" of person
        System.out.println("Are adding a person(0), student(1), or coach(2)");
        // Variable to hold the new contact
        Person p;
        // Num to specify which type of person is being added to the list
        int num = s.nextInt();
        s.nextLine();
        // Asks for necessary attributes for all Person objects
        System.out.println("Enter their first name:");
        String firstName = s.nextLine();
        System.out.println("Enter their last name:");
        String lastName = s.nextLine();
        System.out.println("Enter a phone number:");
        String phoneNumber = s.nextLine();
        // Asks for type-specific attributes (if applicable), then creates the new Person to then be added to the list
        if (num == 1) {
            System.out.println("Enter a grade:");
            int grade = s.nextInt();
            s.nextLine();
            p = new Student(firstName, lastName, phoneNumber, grade);
        } else if (num == 2) {
            System.out.println("Enter a sport:");
            String sport = s.nextLine();
            p = new Coach(firstName, lastName, phoneNumber, sport);
        } else {
            p = new Person(firstName, lastName, phoneNumber);
        }
        // Adds new contact to the list
        addContact(p);
    }

    // Main method to create the list and run the menu
    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}
