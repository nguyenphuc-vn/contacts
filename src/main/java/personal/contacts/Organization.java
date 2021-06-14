package personal.contacts;

import java.time.LocalDateTime;

public class Organization extends People {
    private String address;

    public Organization() {
    }

    public Organization(String name, String number, String address) {
        super(name, number);
        this.address = address;
    }

    public Organization(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
