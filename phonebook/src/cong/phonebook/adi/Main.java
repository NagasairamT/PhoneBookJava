package cong.phonebook.adi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void searchContact(String searchCriteria) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchCriteria)
                    || contact.getPhoneNumber().equalsIgnoreCase(searchCriteria)
                    || contact.getEmail().equalsIgnoreCase(searchCriteria)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void updateContact(String searchCriteria) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchCriteria)
                    || contact.getPhoneNumber().equalsIgnoreCase(searchCriteria)
                    || contact.getEmail().equalsIgnoreCase(searchCriteria)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                System.out.println("Enter new phone number:");
                String newPhoneNumber = scanner.nextLine();
                System.out.println("Enter new email:");
                String newEmail = scanner.nextLine();
                contact.setName(newName);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact updated successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String searchCriteria) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equalsIgnoreCase(searchCriteria)
                    || contact.getPhoneNumber().equalsIgnoreCase(searchCriteria)
                    || contact.getEmail().equalsIgnoreCase(searchCriteria)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("\nPhoneBook System\n");
            System.out.println("1. Add Contact ");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, email);
                    phoneBook.addContact(newContact);
                    break;
                case 2:
                    System.out.println("Enter search criteria:");
                    String searchCriteria = scanner.nextLine();
                    phoneBook.searchContact(searchCriteria);
                    break;
                case 3:
                    System.out.println("Enter search criteria:");
                    searchCriteria = scanner.nextLine();
                    phoneBook.updateContact(searchCriteria);
                    break;
                case 4:
                    System.out.println("Enter search criteria:");
                    searchCriteria = scanner.nextLine();
                    phoneBook.deleteContact(searchCriteria);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}