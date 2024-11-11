package ContactManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagerConsole {
    private List<Contact> contacts;

    public ContactManagerConsole() {
        contacts = new ArrayList<>();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            System.out.println("Contact Manager Console");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Remove Contact");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    listContacts();
                    break;
                case 3:
                    removeContact(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added.");
    }

    private void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private void removeContact(Scanner scanner) {
        listContacts();
        System.out.print("Enter the contact number to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact removed.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public static void main(String[] args) {
        ContactManagerConsole manager = new ContactManagerConsole();
        manager.showMenu();
    }
}
