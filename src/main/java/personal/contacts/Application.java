package personal.contacts;


import java.util.List;
import java.util.Scanner;

public class Application {
    private final static Scanner scanner = new Scanner(System.in).useDelimiter("[\\s\n]");
    private static Contactable contactable;

    public static void main(String[] args) {
        contactable = new Contacts();
        mainUI();
    }

    private static void mainUI() {
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        String action = scanner.nextLine();
        caseUI(action);
    }

    private static void caseUI(String action) {
        List<People> contacts = Contacts.contacts;

        switch (action) {
            case "add":
                askContactInfo();
                break;
            case "remove":
                askRemoveIndex(contacts);
                break;
            case "edit":
                askEditInfo(contacts);
                break;
            case "info":
                printContactsDetails(contacts);
                mainUI();
                break;
            case "count":
                countContacts(contacts);
                break;
            case "exit":
                exit();
        }
    }

    private static void askEditInfo(List<People> contacts) {
        printContactsInfo(contacts);
        int index = askRecord("Select a record: ");
        if(index ==-1){
            System.out.println("No records to edit");
        }
        else {
            String selectedField = selectField(contacts.get(index));
            String inputSelectedFiled = getInputSelectField(selectedField);
            contactable.edit(selectedField, inputSelectedFiled, contacts.get(index));
        }
        mainUI();
    }
    private static String selectField(People people) {
        if (people instanceof Person) {
            System.out.print("Select a field (name, surname, birth, gender, number):");
            return scanner.nextLine();
        }
        System.out.print("Select a field (name, address, number):");
        return scanner.nextLine();
    }

    private static String getInputSelectField(String selectFiled) {
        System.out.printf("Enter %s: ", selectFiled);
        return scanner.nextLine();
    }

    private static int askRecord(String message) {
        System.out.print(message);
        try{
            int value = Integer.parseInt(scanner.next()) - 1;
            scanner.nextLine();
            return value;
        }catch (NumberFormatException ex){
            System.err.print("Error input");
        }
        return -1;
    }

    private static void printContactsInfo(List<People> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            People people = contacts.get(i);
            System.out.printf("%d. %s\n", i + 1, people.getName(people));
        }
    }

    private static String askContactType() {
        System.out.print("Enter the type (person, organization):");
        return scanner.nextLine();
    }

    private static boolean checkEmpty(String str) {
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
        ContactsDetails contactsDetails;
        if (type.equalsIgnoreCase("person")) {
            name = askName();
            surname = askSurname();
            birthDate = askBirthDate();
            gender = askGender();
            number = askNumber();
            contactsDetails = new ContactsDetails(name, surname, birthDate, gender, number);
        } else {
            name = askOrganizationName();
            address = askAddress();
            number = askNumber();
            contactsDetails = new ContactsDetails(name, number, address);
        }
        contactsDetails.setType(type);
        contactable.add(contactsDetails);
        System.out.print("The record added.\n\n");
        mainUI();
    }

    private static String askName() {
        System.out.print("Enter the name: ");
        return scanner.nextLine();
    }

    private static String askOrganizationName() {
        System.out.print("Enter the organization name: ");
        return scanner.nextLine();
    }

    private static String askSurname() {
        System.out.print("Enter the surname: ");
        return scanner.nextLine();
    }

    private static String askNumber() {
        System.out.print("Enter the number: ");
        //scanner.nextLine();
        return scanner.nextLine();
    }

    private static String askBirthDate() {
        System.out.print("Enter the birth date: ");
        String birthDate = scanner.nextLine();
        if (checkEmpty(birthDate)) {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }
        return birthDate;
    }

    private static String askGender() {
        System.out.print("Enter the gender (M, F): ");
        String gender = scanner.nextLine();
        if (checkEmpty(gender) || !(gender.equals("M") || gender.equals("F"))) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        return gender;
    }

    private static String askAddress() {
        System.out.print("Enter the address: ");
        return scanner.nextLine();
    }

    private static void exit() {
        System.exit(0);
    }

    private static void askRemoveIndex(List<People> contacts) {
        String error = "No records to remove!";
        contacts = containValue(error);
        printContactsDetails(contacts);
        int index = askRecord("Select a record: ");
        Contacts.contacts.remove(index);
        mainUI();
    }

    private static void printContactsDetails(List<People> contacts) {
        printContactsInfo(contacts);
        int record = askRecord("Enter index to show info: ");
        if(record<0){
            mainUI();
        }else {
            People people = contacts.get(record);
            if (people instanceof Person) {
                System.out.printf("Name: %s\nSurname: %s\nBirth date: %s" +
                                "\nGender: %s\nNumber: %s\nTime created: %s" +
                                "\nTime last edit: %s\n\n",
                        people.getName(),
                        ((Person) people).getSurname(),
                        ((Person) people).getBirthDate(),
                        ((Person) people).getGender(),
                        people.getNumber(),
                        people.getCreatedTime(),
                        people.getEditedTime());
            } else if (people instanceof Organization) {
                System.out.printf("Organization name: %s\nAddress: %s\nNumber: %s\n" +
                                "Time created: %s\nTime last edit: %s\n\n",
                        people.getName(people),
                        ((Organization) people).getAddress(),
                        people.getNumber(),
                        people.getCreatedTime(),
                        people.getEditedTime());
            }
        }
    }

    private static List<People> containValue(String errorMessage) {
        List<People> contacts = Contacts.contacts;
        if (contacts.isEmpty()) {
            System.out.println(errorMessage);
            mainUI();
        }
        return contacts;
    }

    private static void countContacts(List<People> contacts) {
        System.out.printf("The Phone Book has %d records.", contacts.size());
        mainUI();
    }
}