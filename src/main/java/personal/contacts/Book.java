package personal.contacts;

import java.util.List;

public interface Book {
    Person add(String name, String surname, String number);
    public void remove(int index);
    public Person edit(Person person);
    public int count(List<Person> people);
    public List<Person> getContact();

}
