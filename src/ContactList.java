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

    public void addContact(Person p) {
        contacts.add(p);
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void sort(int sortBy) {
        Person temp;
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(i).getFirstName().compareTo(contacts.get(i + 1).getFirstName()) > 0) {
                        temp = contacts.get(i);
                        contacts.set(i, contacts.get(i + 1));
                        contacts.set(i + 1, temp);
                    }
                }
            }
        } else if (sortBy == 1) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(i).getLastName().compareTo(contacts.get(i + 1).getLastName()) > 0) {
                        temp = contacts.get(i);
                        contacts.set(i, contacts.get(i + 1));
                        contacts.set(i + 1, temp);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    if (contacts.get(i).getPhoneNumber().compareTo(contacts.get(i + 1).getPhoneNumber()) > 0) {
                        temp = contacts.get(i);
                        contacts.set(i, contacts.get(i + 1));
                        contacts.set(i + 1, temp);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName))
                return p;
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName))
                return p;
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber))
                return p;
        }
        return null;
    }

    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student)
                System.out.println(p);
        }
    }

    public void run() {
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last " +
                            "Name\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First " +
                            "Name\n7. Search By Last Name\n8. Search By Phone Number\n0. Exit");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.nextLine();
        if (num == 1) {

        }
    }
}
