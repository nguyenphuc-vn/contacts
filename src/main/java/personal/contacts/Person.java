package personal.contacts;

public class Person {
    private String name;
    private String surname;
    private String number;

    private Person(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        number = builder.number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static class Builder {
        private final String name;
        private final String surname;
        private String number = "[no number]";

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
