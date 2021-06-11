package personal.contacts;

import java.util.List;

public interface Book {
    public Person add(String name, String surname, String number);

    public void remove(int index);

    public void edit(int index, String chooseField, String field);

    public int count();

    public List<Person> getContact();
}
