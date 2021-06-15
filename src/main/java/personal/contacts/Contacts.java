package personal.contacts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts implements Contactable {
    public static final List<People> contacts = new ArrayList<>();

    @Override
    public void add(ContactsDetails contactsDetails) {
        if (!isValidNumber(contactsDetails.getNumber())) {
            contactsDetails.setNumber("[no number]");
            System.out.println("Wrong number format!");
        }
        if(parseBirthDate(contactsDetails.getBirthDate())==null){
            contactsDetails.setBirthDate("[no data]");
        }
        contacts.add(ContactsFactoryProvider.getContactsFactory().getContacts(contactsDetails));
    }

    private boolean isValidNumber(String number) {
        Pattern numberPattern = Pattern
                .compile(phonePattern());
        Matcher matcher = numberPattern.matcher(number);
        return matcher.matches();
    }
    private String parseBirthDate(String value){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(value);
            return date.toString();
        }catch (ParseException exception){
            System.err.println("Cannot parse birthdate");
        }
        return null;
    }

    private String phonePattern() {
        return "[+]?([\\w]+([- ]([\\w]){2,4})?|\\([\\w]+\\)([- ]([\\w]){2,4})?|([\\w])+([- ]\\((\\w]){2,4}\\))?)([ -][\\w]{2,4})*";
    }

    @Override
    public void edit(String selectedField, String input, People people) {
        switch (selectedField) {
            case "name":
                people.setName(input);
                break;
            case "number":
                setNumber(input, people);
                break;
            case "surname":
                getPerson(people).setSurname(input);
                break;
            case "birth":
                getPerson(people).setBirthDate(input);
                break;
            case "gender":
                getPerson(people).setGender(input);
                break;
            case "address":
                getOrganization(people).setAddress(input);
                break;
        }
        people.setEditedTime();
        System.out.print("The record updated!\n\n");
    }

    private void setNumber(String input, People people) {
        if (isValidNumber(input)) {
            people.setNumber(input);
        } else
            people.setNumber("[no number]");
    }

    private Person getPerson(People people) {
        return (Person) people;
    }

    private Organization getOrganization(People people) {
        return (Organization) people;
    }
}
