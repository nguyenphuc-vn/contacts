package personal.contacts;

public class ContactsFactory extends AbstractContactsFactory {
    @Override
    public People getContacts(ContactsDetails contactsDetails) {
        People people = null;
        switch (contactsDetails.getType()) {
            case "person":
                people = new Person(
                        contactsDetails.getName(),
                        contactsDetails.getNumber(),
                        contactsDetails.getSurname(),
                        contactsDetails.getBirthDate(),
                        contactsDetails.getGender());
                break;
            case "organization":
                people = new Organization(
                        contactsDetails.getName(),
                        contactsDetails.getNumber(),
                        contactsDetails.getAddress());
                break;
            default:
                System.err.println("Unknown contacts type");
        }
        return people;
    }
}