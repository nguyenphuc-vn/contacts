package personal.contacts;

import java.util.List;
import java.util.Scanner;

public class Application {
    private final static Scanner scanner = new Scanner(System.in);
    private static Contactable contactable;

    public static void main(String[] args) {
        contactable = new Contacts();
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
            case "exit":
                exit();
        }
    }

    private static String askContactType(){
        System.out.println("Enter the type (person, organization):");
        scanner.nextLine();
        return scanner.nextLine();
    }
    private static boolean getContactType(String type){
        People people =ContactsFactory.getContacts(type);
        return people instanceof Individual ;
    }
    private static boolean checkEmpty(String str){
        return str.isBlank() || str.isEmpty();
    }
    private static void askContactInfo() {
        String name;
        String surname;
        String number;
        String birthDate;
        String gender;
        String address;
        String type = askContactType();
        boolean isPerson = getContactType(type);
        if(isPerson){
            name = askName();
            surname = askSurname();
            birthDate = askBirthDate();
            gender = askGender();
            number = askNumber();
            contactable.addPerson(name, surname, birthDate, gender, number);
        }else{
            name = askOrganizationName();
            address = askAddress();
            number = askNumber();
            contactable.addGroup(name, address, number);
        }
        System.out.println("The record added.");
        mainUI();
    }

    private static String askName(){
        System.out.println("Enter the name:");
        return scanner.nextLine();
    }
    private static String askOrganizationName(){
        System.out.println("Enter the organization name:");
        return scanner.nextLine();
    }
    private static String askSurname(){
        System.out.println("Enter the surname:");
        return scanner.nextLine();
    }
    private static String askNumber(){
        System.out.println("Enter the number:");
        return scanner.nextLine();
    }
    private static String askBirthDate(){
        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        if(checkEmpty(birthDate)){
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        return birthDate;
    }
    private static String askGender(){
        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if(checkEmpty(gender)){
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        return gender;
    }
    private static String askAddress(){
        System.out.println("Enter the address:");
        return scanner.nextLine();
    }

    private static void exit() {
        System.exit(0);
    }

   /* private static void countContacts() {
        System.out.printf("The Phone Book has %d records.\n", contactable.count());
        mainUI();
    }

    private static void askEditIndex() {
        String error = "No records to edit!";
        List<Individual> contacts = containValue(error);
        printContacts(contacts);
        System.out.println("Select a record:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        String chooseField = askThingsToBeEdited();

        String field = askEditField(chooseField);
        contactable.edit(index, chooseField, field);
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
        List<Individual> contacts = containValue(error);
        printContacts(contacts);
        int index = scanner.nextInt() - 1;
        contactable.remove(index);
        mainUI();
    }


    private static List<Individual> containValue(String errorMessage) {
        List<Individual> contacts = contactable.getContact();
        if (contacts.isEmpty()) {
            System.out.println(errorMessage);
            mainUI();
        }
        return contacts;
    }

    private static void printContacts(List<Individual> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            String output = String.format("%d. %s %s, %s",
                    i + 1,
                    contacts.get(i).getName(),
                    contacts.get(i).getSurname(),
                    contacts.get(i).getNumber());
            System.out.println(output);
        }
    }*/


}
