package personal.contacts;

public class Organization extends People {
    private String address;

    public Organization(String name, String number, String address) {
        super(name, number);
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
