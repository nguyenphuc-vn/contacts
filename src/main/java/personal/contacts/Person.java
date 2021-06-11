package personal.contacts;

public class Person {
    private String name;
    private String surname;
    private String number;

    public static class Builder {
        private final String name;
        private final String surname;
        private String number ="[no number]";

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder setNumber(String number){
            this.number = number;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
    private Person(Builder builder){
        name = builder.name;
        surname = builder.surname;
        number = builder.number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }
}
