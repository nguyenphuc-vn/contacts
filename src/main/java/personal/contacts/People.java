package personal.contacts;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class People {
    private String name;
    private String number;
    private LocalDateTime createdTime;
    private LocalDateTime editedTime;

    public People(String name, String number) {
        this.name = name;
        this.number = number;
        this.createdTime = LocalDateTime.now();
        this.editedTime = LocalDateTime.now();
    }

    public People() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name)
                && Objects.equals(number, people.number)
                && Objects.equals(createdTime, people.createdTime)
                && Objects.equals(editedTime, people.editedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, createdTime, editedTime);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", createdTime=" + createdTime +
                ", editedTime=" + editedTime +
                '}';
    }

    public String getName() {
        return name;
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }


    public LocalDateTime getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(LocalDateTime editedTime) {
        this.editedTime = editedTime;
    }
}
