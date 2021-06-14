package personal.contacts;

import java.util.List;

public interface Contactable {
    public void addPerson(String name, String surname,String birthDate,String gender, String number);

    public void addGroup(String name,String address, String number);


}

