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
        if(isValidNumber(number)){
             person = new Person
                    .Builder(name,surname)
                    .setNumber(number)
                    .build();
        }
        else {
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
    public Person edit(Person person) {
        return null;
    }

    @Override
    public int count(List<Person> people) {
        return 0;
    }

    private boolean isValidNumber(String number){
        Pattern numberPattern = Pattern
                .compile(phonePattern(),Pattern.CASE_INSENSITIVE);
        Matcher matcher = numberPattern.matcher(number);
       return matcher.matches();
    }
    private String phonePattern(){
        String pattern = "\\(\\d{3}\\)\\s\\d{3}([- ])\\d{3}(-)\\w{1,4}";
        String prefix = "([+]\\d{1,3})\\s";
        return prefix+pattern+"|"+pattern;
    }

    public List<Person> getContact() {
        return contact;
    }
}
