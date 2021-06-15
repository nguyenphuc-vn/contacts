package personal.contacts;


public class ContactsDetails {
    private final String name;
    private String surname;
    private String birthDate;
    private String gender;
    private String number;
    private String address;
    private String type;

    public ContactsDetails(String name, String surname, String birthDate, String gender, String number) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.number = number;
    }
    public ContactsDetails(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }


    public String getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }
}
