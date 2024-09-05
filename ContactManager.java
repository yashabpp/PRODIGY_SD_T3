import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactManager {
    private Map<String, Contact> contacts;

    public ContactManager() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber, String email) {
        contacts.put(name, new Contact(name, phoneNumber, email));
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public void editContact(String name, String newPhoneNumber, String newEmail) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
                contact.setPhoneNumber(newPhoneNumber);
            }
            if (newEmail != null && !newEmail.isEmpty()) {
                contact.setEmail(newEmail);
            }
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    manager.addContact(name, phoneNumber, email);
                    break;
                case 2:
                    manager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter name of contact to edit: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new phone number (press Enter to leave unchanged): ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email address (press Enter to leave unchanged): ");
                    String newEmail = scanner.nextLine();
                    manager.editContact(editName, newPhoneNumber, newEmail);
                    break;
                case 4:
                    System.out.print("Enter name of contact to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
