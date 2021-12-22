package lesson14;


import java.util.Objects;

public class Contact {

    private String name;
    private String surname;
    private String number;
    private MobileOperator operator;
    private boolean isTownNumber;

    public Contact(String name, String surname, String number, MobileOperator operator, boolean isTownNumber) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.operator = operator;
        this.isTownNumber = isTownNumber;
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

    public MobileOperator getOperator() {
        return operator;
    }

    public void setOperator(MobileOperator operator) {
        this.operator = operator;
    }

    public boolean isTownNumber() {
        return isTownNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname) && Objects.equals(operator, contact.getOperator()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, operator);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", operator=" + operator +
                ", isTownNumber=" + isTownNumber +
                '}';
    }

}
