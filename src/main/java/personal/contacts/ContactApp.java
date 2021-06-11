package personal.contacts;

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
            case "count":
                countContacts();
                break;
            case "list":
                printContacts(book.getContact());
                mainUI();
                break;
            case "exit":
                exit();
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private static void countContacts() {
        System.out.printf("The Phone Book has %d records.\n", book.count());
        mainUI();
    }

    private static void askEditIndex() {
        String error = "No records to edit!";
        List<Person> contacts = containValue(error);
        printContacts(contacts);
        System.out.println("Select a record:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        String chooseField = askThingsToBeEdited();

        String field = askEditField(chooseField);
        book.edit(index, chooseField, field);
        mainUI();

    }

    private static String askThingsToBeEdited() {
        System.out.println("Select a field (name, surname, number):");
        return scanner.nextLine();

    }

    private static String askEditField(String field) {
        System.out.printf("Enter %s:\n", field);
        return scanner.nextLine();
    }

    private static void askRemoveIndex() {
        String error = "No records to remove!";
        List<Person> contacts = containValue(error);
        printContacts(contacts);
        int index = scanner.nextInt() - 1;
        book.remove(index);
        mainUI();
    }


    private static List<Person> containValue(String errorMessage) {
        List<Person> contacts = book.getContact();
        if (contacts.isEmpty()) {
            System.out.println(errorMessage);
            mainUI();
        }
        return contacts;
    }

    private static void printContacts(List<Person> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            String output = String.format("%d. %s %s, %s",
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
