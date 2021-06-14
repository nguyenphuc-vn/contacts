package personal.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Contacts implements Contactable{
    private static final Logger logger = Logger.getLogger(Contacts.class.getName());
    List<People> contacts = new ArrayList<>();

    @Override
    public void addPerson(String name, String surname, String birthDate, String gender, String number) {
        People people = new Individual(name,number,surname,birthDate,gender);
        contacts.add(people);
    }

    @Override
    public void addGroup(String name, String address, String number) {
        People people = new Organization(name,address,number);
        contacts.add(people);
    }


}
