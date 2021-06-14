package personal.contacts;

public class ContactsFactory {
    public static People getContacts(String type){
        if(type.equalsIgnoreCase("person")){

            return new Individual();
        }else if(type.equalsIgnoreCase("organization")){
            return new Organization();
        }
        return null;
    }

}
