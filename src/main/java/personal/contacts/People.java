package personal.contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class People {
    private String name;
    private String number;
    private  LocalDateTime createdTime;
    private LocalDateTime editedTime;

    public People(String name, String number) {
        this.name = name;
        this.number = number;
        this.createdTime = LocalDateTime.now();
        this.editedTime = LocalDateTime.now();
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getEditedTime() {
        return editedTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEditedTime() {
        this.editedTime = LocalDateTime.now();
    }

    public String getName(People people) {
        if (people instanceof Person) {
            Person person = (Person) people;
            return people.name + " " + person.getSurname();
        }
        return people.name;
    }

    public String getName() {
        return name;
    }
}
