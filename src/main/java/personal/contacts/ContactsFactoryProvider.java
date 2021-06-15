package personal.contacts;

public class ContactsFactoryProvider {

    public static AbstractContactsFactory getContactsFactory() {
        return new ContactsFactory();
    }
}
