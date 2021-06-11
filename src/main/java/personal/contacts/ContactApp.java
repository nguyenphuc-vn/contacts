package personal.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactApp {
    private final static Scanner scanner = new Scanner(System.in);
    private static Book book;

    public static void main(String[] args) {
        book = new PhoneBook();
        mainUI();
    }

    private static void mainUI() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        String action = scanner.next();
        caseUI(action);

    }

    private static void caseUI(String action) {
        switch (action) {
            case "add":
                askContactInfo();
                break;
            case "remove":
                askRemoveIndex();
                break;
            case "edit":
                askEditIndex();
                break;
        }
    }

    private static void askEditIndex() {

    }


    private static void askRemoveIndex() {
        List<Person> contacts = book.getContact();
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
            mainUI();
        }
        printContacts(contacts);
        int index = scanner.nextInt() - 1;
        book.remove(index);
        mainUI();
    }

    private static void printContacts(List<Person> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            String output = String.format("%d. %s %s %s",
                    i + 1,
                    contacts.get(i).getName(),
                    contacts.get(i).getSurname(),
                    contacts.get(i).getNumber());
            System.out.println(output);
        }
    }

    private static void askContactInfo() {
        System.out.println("Enter the name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        book.add(name, surname, number);
        System.out.println("The record added.");
        mainUI();
    }
}
