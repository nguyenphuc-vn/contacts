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
        String group1 = "(\\s)(\\w{2,})";
        String group3 = "([-\\s])(\\w{2,})";
        String group4 = "([-\\s])(\\w{2,})";
        String group1P = "(\\(\\w{2,}\\))";
        String group3P = "([-\\s])(\\(\\w{2,}\\))";
        //String group4P = "([-\\s])(\\(\\w{1,}\\))";
        //123
        String case1 = "^(\\w{1,3})";
        //123 abc
        String case2 = case1 + group3;
        //123 abc 2421
        String case3 = case2 + group3;
        // 123 abc 232 1232
        String case4 = case3 + group4;
        // (123)
        String case5 = "^(\\(\\w{1,3}\\))";
        // (123) abc
        String case6 = case5 + group3;
        // (123) abc abc
        String case7 = case6 + group3;
        // (123) 123 123 123
        String case8 = case7 + group4;
        // +012
        String case9 = "([+]\\w{1,})";
        // +112 abc
        String case10 = case9 + group1;
        // +112 abc abc
        String case11 = case10 + group3;
        // +112 abc abc abc
        String case12 = case11 + group4;
        // +012 (abc)
        String case13 = case12 + group1P;
        // +022 (abc) abc
        String case14 = case13 + group3;
        // +122 (abc) abc abc
        String case15 = case14 + group4;
        // +121 abc (abc)
        String case16 = case15 + group3P;
        // +112 abc (abc) abc
        String case17 = case16 + group4;
        // 123 (123)
        String case18 = case1 + group3P;
        // 123 (123) 123
        String case19 = case18 + group3;
        // 123 (123) 123 123
        String case20 = case19 + group4;
        // +(word)
        String case21 = "([+]\\(\\w+\\))";
        return case1 + "|" + case2 + "|" + case3 + "|"
                + case4 + "|" + case5 + "|" + case6 + "|" + case7 + "|"
                + case8 + "|" + case9 + "|" + case10 + "|"
                + case11 + "|" + case12 + "|" + case13 + "|"
                + case14 + "|" + case15 + "|" + case16 + "|" + case17+"|"
                + case18 + "|" + case19 + "|" + case20+"|"+ case21;

    }

    public List<Person> getContact() {
        return contact;
    }
}

