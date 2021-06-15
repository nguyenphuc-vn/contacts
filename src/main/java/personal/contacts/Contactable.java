package personal.contacts;

public interface Contactable {
    void add(ContactsDetails contactsDetails);

    void edit(String selectedField, String inputSelectedFiled, People people);
}

