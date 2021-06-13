package personal.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Book {
    private List<Person> contact;

    public PhoneBook() {
        contact = new ArrayList<>();
    }

    @Override
    public Person add(String name, String surname, String number) {
        Person person;
        if (isValidNumber(number)) {
            person = new Person
                    .Builder(name, surname)
                    .setNumber(number)
                    .build();
        } else {
            person = new Person
                    .Builder(name, surname)
                    .build();
            System.out.println("Wrong number format!");
        }
        contact.add(person);
        return person;
    }

    @Override
    public void remove(int index) {
        contact.remove(index);
        System.out.println("The record removed!");
    }

    @Override
    public void edit(int index, String chooseField, String field) {
        Person tempPerson = contact.get(index);
        switch (chooseField) {
            case "name":
                tempPerson.setName(field);
                break;
            case "surname":
                tempPerson.setSurname(field);
                break;
            case "number":
                helper(tempPerson, field);
                break;
        }
        System.out.println("The record updated!");
    }

    private void helper(Person person,String field){
        if(isValidNumber(field)){
            person.setNumber(field);
        }
        else
            person.setNumber("[no number]");
    }
    @Override
    public int count() {
        return contact.size();
    }

    private boolean isValidNumber(String number) {
        Pattern numberPattern = Pattern
                .compile(phonePattern(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = numberPattern.matcher(number);
        return matcher.matches();
    }


    private String phonePattern() {
        return  "^\\+?\\w{0,}[- ]?(\\w{2,})?([- ]\\w{2,})?([- ]\\w{2,})?$"+"|"
                +"^\\(\\w{0,}\\)([- ]\\w{0,})?([- ]\\w{0,})?$"+"|"
                +"^\\w{0,}[- ]\\(\\w{0,}\\)([- ]\\w{0,})?([- ]\\w{0,})?$|^\\+\\(\\w+\\)$";



    }

    public List<Person> getContact() {
        return contact;
    }
}

